package com.nas.deliv.brandservice.service.feign.request;


import lombok.Getter;

@Getter
public class CategoryCommand {
    private String categoryName;
    private String companyId;
}
