package com.nas.deliv.userservice.service;


import com.nas.deliv.userservice.command.CustomerCreatedCommand;
import com.nas.deliv.userservice.enums.ClientType;
import com.nas.deliv.userservice.models.ConfirmationToken;
import com.nas.deliv.userservice.models.Customer;
import com.nas.deliv.userservice.repository.ConfirmationTokenRepository;
import com.nas.deliv.userservice.repository.CustomerRepository;
import com.nas.deliv.userservice.service.customer.CustomerServiceImpl;
import exception.BusinessException;
import exception.ExceptionPayloadFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateNewCustomer() {
        CustomerCreatedCommand command = new CustomerCreatedCommand();
        command.setFirstName("Anas");
        command.setLastName("Abbal");
        command.setPhoneNumber("123456789");
        command.setEmail("john@example.com");
        command.setPassword("password123");
        command.setClientType(ClientType.PERSON);

        Customer customer = Customer.create(command);
        when(customerRepository.existsCustomerByAccountInformation_Email(command.getEmail())).thenReturn(false);
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);
        ConfirmationToken confirmationToken = new ConfirmationToken(customer);
        when(confirmationTokenRepository.save(any(ConfirmationToken.class))).thenReturn(confirmationToken);

        String result = customerService.create(command);

        verify(customerRepository, times(1)).existsCustomerByAccountInformation_Email(command.getEmail());
        verify(customerRepository, times(1)).save(any(Customer.class));
        verify(confirmationTokenRepository, times(1)).save(any(ConfirmationToken.class));
        verify(emailService, times(1)).sendEmail(any(SimpleMailMessage.class));
    }
    @Test
    void testCreateCustomerWithExistingEmail() {
        CustomerCreatedCommand command = createTestCommand();

        when(customerRepository.existsCustomerByAccountInformation_Email(anyString())).thenReturn(true);

        try {
            customerService.create(command);
        } catch (BusinessException e) {
            throw new BusinessException(ExceptionPayloadFactory.EMAIL_ALREADY_EXIST.get());
        }

        // Verify that the save methods and sendEmail method were not called in this case.
        verify(customerRepository, never()).save(any());
        verify(confirmationTokenRepository, never()).save(any());
        verify(emailService, never()).sendEmail(any());
    }
    @Test
    void testGetCustomers() {
        // Create a test Pageable
        Pageable pageable = createTestPageable();

        // Create a test Page<Customer>
        Page<Customer> testPage = createTestPage();

        // Mock the repository call
        when(customerRepository.findAllByDeletedFalse(any(Pageable.class))).thenReturn(testPage);

        // Call the service method
        Page<Customer> resultPage = customerService.getCustomers(pageable);

        // Add assertions based on your business logic
        assertNotNull(resultPage);
        assertEquals(testPage.getContent().size(), resultPage.getContent().size());

        // Verify repository calls
        verify(customerRepository, times(1)).findAllByDeletedFalse(any(Pageable.class));
    }
    private CustomerCreatedCommand createTestCommand() {
        CustomerCreatedCommand command = new CustomerCreatedCommand();
        command.setFirstName("Anas");
        command.setLastName("Abbal");
        command.setPhoneNumber("123456789");
        command.setEmail("john@example.com");
        command.setPassword("password123");
        command.setClientType(ClientType.PERSON);

        return command;
    }

    private Customer createTestCustomer() {
        CustomerCreatedCommand command = createTestCommand();
        return Customer.create(command);
    }

    private Pageable createTestPageable() {
        return Pageable.unpaged();
    }

    private Page<Customer> createTestPage() {
        return new PageImpl<>(Collections.singletonList(createTestCustomer()));
    }
}
