package com.nas.deliv.userservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountInformationDto extends BaseDto{
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
}
