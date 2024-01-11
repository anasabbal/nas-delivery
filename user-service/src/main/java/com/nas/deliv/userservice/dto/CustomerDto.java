package com.nas.deliv.userservice.dto;


import com.nas.deliv.userservice.enums.ClientType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto extends BaseDto{


    private AccountInformationDto accountInformation;
    private ClientType clientType;
    private boolean isEnabled;
}
