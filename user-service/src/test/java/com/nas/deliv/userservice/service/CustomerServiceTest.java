package com.nas.deliv.userservice.service;


import com.nas.deliv.userservice.command.CustomerCreatedCommand;
import com.nas.deliv.userservice.enums.ClientType;
import com.nas.deliv.userservice.models.ConfirmationToken;
import com.nas.deliv.userservice.models.Customer;
import com.nas.deliv.userservice.repository.ConfirmationTokenRepository;
import com.nas.deliv.userservice.repository.CustomerRepository;
import com.nas.deliv.userservice.service.customer.CustomerServiceImpl;
import exception.BusinessException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.SimpleMailMessage;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CustomerServiceImplTest {

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
        // Arrange
        // Arrange
        CustomerCreatedCommand command = new CustomerCreatedCommand();
        command.setFirstName("John");
        command.setLastName("Doe");
        command.setPhoneNumber("123456789");
        command.setEmail("john@example.com");
        command.setPassword("password123");
        command.setClientType(ClientType.PERSON);

        Customer customer = Customer.create(command);
        when(customerRepository.existsCustomerByAccountInformation_Email(command.getEmail())).thenReturn(false);
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);
        ConfirmationToken confirmationToken = new ConfirmationToken(customer);
        when(confirmationTokenRepository.save(any(ConfirmationToken.class))).thenReturn(confirmationToken);

        // Act
        String result = customerService.create(command);

        // Assert
        verify(customerRepository, times(1)).existsCustomerByAccountInformation_Email(command.getEmail());
        verify(customerRepository, times(1)).save(any(Customer.class));
        verify(confirmationTokenRepository, times(1)).save(any(ConfirmationToken.class));
        verify(emailService, times(1)).sendEmail(any(SimpleMailMessage.class));

        // Add more assertions based on your specific requirements
        // Example: Check the result or additional verifications
    }

    @Test
    void testCreateCustomerWithExistingEmail() {
        // Arrange
        CustomerCreatedCommand command = new CustomerCreatedCommand();
        command.setFirstName("John");
        command.setLastName("Doe");
        command.setPhoneNumber("123456789");
        command.setEmail("john@example.com");
        command.setPassword("password123");
        command.setClientType(ClientType.PERSON);

        when(customerRepository.existsCustomerByAccountInformation_Email(command.getEmail())).thenReturn(true);

        assertThrows(BusinessException.class, () -> customerService.create(command));
    }
}
