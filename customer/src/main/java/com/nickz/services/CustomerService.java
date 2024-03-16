package com.nickz.services;

import com.nickz.controllers.CustomerRegistrationRequest;
import com.nickz.entity.Customer;
import com.nickz.isIllegal.IsIllegal;
import com.nickz.isIllegal.ValidCheckResponse;
import com.nickz.repostitories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService{

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final IsIllegal isIllegal;
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        // TODO: 3/15/2024  send notification
        customerRepository.saveAndFlush(customer);

        ValidCheckResponse checkResponse = isIllegal.isValid(customer.getId());

        if(checkResponse.isIllegal()){
            throw new IllegalStateException("isIllegal");
        }
    }
}
