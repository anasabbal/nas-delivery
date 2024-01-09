package com.nas.deliv.userservice.models;


import com.nas.deliv.userservice.command.CustomerCreatedCommand;
import com.nas.deliv.userservice.enums.ClientType;
import jakarta.persistence.*;
import lombok.*;
import shared.BaseEntity;


@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer  extends BaseEntity {


    @OneToOne(cascade = CascadeType.ALL)
    private AccountInformation accountInformation;

    @Enumerated(EnumType.STRING)
    private ClientType clientType;

    @Column(name = "IS_ENABLED")
    private boolean isEnabled;


    public static Customer createAndSave(final AccountInformation accountInformation, ClientType clientType){
        final Customer customer = new Customer();
        customer.accountInformation = accountInformation;
        customer.clientType = clientType;

        return customer;
    }
    public static Customer create(final CustomerCreatedCommand command){
        final AccountInformation accountInformation = AccountInformation.create(command);
        return Customer.createAndSave(accountInformation, command.getClientType());
    }
}
