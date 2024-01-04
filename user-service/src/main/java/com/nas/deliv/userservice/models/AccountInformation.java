package com.nas.deliv.userservice.models;

import com.nas.deliv.userservice.command.CustomerCreatedCommand;
import jakarta.persistence.Entity;
import shared.BaseEntity;



@Entity
public class AccountInformation extends BaseEntity {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;


    public static AccountInformation create(final CustomerCreatedCommand command){
        final AccountInformation accountInformation = new AccountInformation();

        accountInformation.firstName = command.getFirstName();
        accountInformation.lastName = command.getLastName();
        accountInformation.phoneNumber = command.getPhoneNumber();
        accountInformation.email = command.getEmail();
        accountInformation.password = command.getPassword();

        return accountInformation;
    }
}
