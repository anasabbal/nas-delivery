package com.nas.deliv.userservice.dto.mapper;

import com.nas.deliv.userservice.dto.AccountInformationDto;
import com.nas.deliv.userservice.models.AccountInformation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AccountInformationMapper {
    public abstract AccountInformationDto toDto(AccountInformation accountInformation);
}
