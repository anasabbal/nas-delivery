package com.nas.deliv.productservice.command;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCommand {
    private String productName;
    private String companyName;
    private Float price;
}
