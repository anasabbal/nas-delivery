package com.nas.deliv.categoryservice.feign;


import com.nas.deliv.categoryservice.feign.response.CompanyFeignResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8086/v1/company/")
public interface CategoryFeignCompany {

    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyFeignResponse> findById(@PathVariable("companyId") final String companyId);
}
