package com.nas.deliv.userservice.models;


import com.nas.deliv.userservice.command.CustomerCreatedCommand;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import shared.BaseEntity;


@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer  extends BaseEntity {
    @OneToOne
    private AccountInformation accountInformation;


    public static Customer createAndSave(final AccountInformation accountInformation){
        final Customer customer = new Customer();
        customer.accountInformation = accountInformation;

        return customer;
    }
    public static Customer create(final CustomerCreatedCommand command){
        final AccountInformation accountInformation = AccountInformation.create(command);
        return Customer.createAndSave(accountInformation);
    }
}
