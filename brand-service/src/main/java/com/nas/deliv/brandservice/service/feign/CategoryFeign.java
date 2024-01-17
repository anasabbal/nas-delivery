package com.nas.deliv.brandservice.service.feign;


import com.nas.deliv.brandservice.service.feign.request.CategoryCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:8090/v1/category", name = "product")
public interface CategoryFeign {
    @PostMapping
    public ResponseEntity<String> create(@RequestBody final CategoryCommand categoryCommand);
}
