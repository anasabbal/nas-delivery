package com.nas.deliv.userservice.models;

import jakarta.persistence.Entity;
import lombok.*;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;


@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="TOKEN_ID")
    private Long tokenId;

    @Column(name="CONFIRMATION_TOKEN")
    private String confirmationToken;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @OneToOne(targetEntity = Customer.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "customer_id")
    private Customer customer;

    public ConfirmationToken(Customer customer) {
        this.customer = customer;
        createdDate = new Date();
        confirmationToken = UUID.randomUUID().toString();
    }
}
