package com.nas.deliv.userservice.event.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateBrandRequest {
    private String companyName;
    private String companyType;
    private String customerId;


    public static CreateBrandRequest create(final String companyName, String companyType, String customerId){
        final CreateBrandRequest createBrandRequest = new CreateBrandRequest();
        createBrandRequest.companyName = companyName;
        createBrandRequest.companyType = companyType;
        createBrandRequest.customerId = customerId;

        return createBrandRequest;
    }
}
