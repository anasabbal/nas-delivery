package com.nas.deliv.userservice.controller;


import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(AuthController.class)
public class AuthControllerTest {

    /*@Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @MockBean
    private ConfirmationTokenService confirmationTokenService;

    @Test
    void testRegisterEndpoint() throws Exception {
        // Arrange
        CustomerCreatedCommand command = new CustomerCreatedCommand();
        command.setFirstName("John");
        command.setLastName("Doe");
        command.setPhoneNumber("123456789");
        command.setEmail("john@example.com");
        command.setPassword("password123");

        when(customerService.create(any(CustomerCreatedCommand.class))).thenReturn("Verify email by the link sent on your email address");

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(command)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Verify email by the link sent on your email address"));
    }
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/

}
