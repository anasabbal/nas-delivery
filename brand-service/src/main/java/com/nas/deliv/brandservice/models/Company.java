package com.nas.deliv.brandservice.models;


import com.nas.deliv.brandservice.command.CompanyCommand;
import com.nas.deliv.brandservice.enums.CompanyType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import shared.BaseEntity;




@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Company extends BaseEntity {

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Enumerated(EnumType.STRING)
    @Column(name = "COMPANY_TYPE")
    private CompanyType companyType;

    public static Company create(final CompanyCommand companyCommand){
        final Company company = new Company();

        company.companyName = companyCommand.getCompanyName();
        company.companyType = companyCommand.getCompanyType();

        return company;
    }
}
