package com.nas.deliv.userservice.command;


import lombok.Getter;

@Getter
public class AccountInformationUpdatedCommand {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
