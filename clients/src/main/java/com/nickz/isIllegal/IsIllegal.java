package com.nickz.isIllegal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("validationcheck")
public interface IsIllegal {
    @GetMapping(path = "api/v1/valid-check/{customerId}")
    ValidCheckResponse isValid(
            @PathVariable("customerId") Integer customerId);
}
