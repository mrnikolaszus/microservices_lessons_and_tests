package com.nickz.validationCheck.controllers;

import com.nickz.isIllegal.ValidCheckResponse;
import com.nickz.validationCheck.services.ValidationCheckService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/valid-check")
@AllArgsConstructor
@Slf4j
public class ValidationCheckController {

    private final ValidationCheckService validationCheckService;


    @GetMapping(path = "{customerId}")
    public ValidCheckResponse isValid(
            @PathVariable("customerId") Integer customerId){
        boolean isIllegalCustomer = validationCheckService.isIllegalCustomer(customerId);
        log.info("checking illegal request for customer {}", customerId);

        return new ValidCheckResponse(isIllegalCustomer);


    }
}
