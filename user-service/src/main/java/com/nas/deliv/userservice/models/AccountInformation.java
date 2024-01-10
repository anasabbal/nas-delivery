package com.nas.deliv.userservice.models;

import com.nas.deliv.userservice.command.AccountInformationUpdatedCommand;
import com.nas.deliv.userservice.command.CustomerCreatedCommand;
import jakarta.persistence.Entity;
import lombok.Getter;
import shared.BaseEntity;




@Getter
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
    public void update(AccountInformationUpdatedCommand command){
        this.firstName = command.getFirstName();
        this.lastName = command.getLastName();
        this.email = command.getEmail();
        this.phoneNumber = command.getPhoneNumber();
    }
}
