package com.nas.deliv.brandservice.command;


import com.nas.deliv.brandservice.enums.CompanyType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyCommand {
    private String companyName;
    private CompanyType companyType;
    private String customerId;
}
