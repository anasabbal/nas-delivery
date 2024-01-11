package com.nas.deliv.userservice.event.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyCreatedEvent {
    private String companyName;
    private String companyType;
    private String ceo;
}
