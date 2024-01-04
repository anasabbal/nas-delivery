package com.nas.deliv.userservice.command;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCreatedCommand {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
}
