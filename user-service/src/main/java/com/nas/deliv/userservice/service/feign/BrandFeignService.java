package com.nas.deliv.userservice.service.feign;


import com.nas.deliv.userservice.event.request.CreateBrandRequest;
import com.nas.deliv.userservice.event.response.CompanyCreatedEvent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "company", url = "http://localhost:8086/v1/company")
public interface BrandFeignService {

    @PostMapping()
    CompanyCreatedEvent createBrand(@RequestBody CreateBrandRequest createBrandRequest);
}
