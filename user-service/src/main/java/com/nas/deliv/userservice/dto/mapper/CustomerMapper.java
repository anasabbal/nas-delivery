package com.nas.deliv.userservice.dto.mapper;


import com.nas.deliv.userservice.dto.CustomerDto;
import com.nas.deliv.userservice.models.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CustomerMapper {
    public abstract CustomerDto toCustomerDto(Customer customer);
    public abstract List<CustomerDto> toListOfCustomerDto(List<Customer> customers);
}
