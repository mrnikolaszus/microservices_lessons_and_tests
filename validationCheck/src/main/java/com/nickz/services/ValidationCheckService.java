package com.nickz.services;

import com.nickz.entity.ValidationCheckHistory;
import com.nickz.repositories.ValidationCheckHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ValidationCheckService {

    private final ValidationCheckHistoryRepository validationCheckHistoryRepository;


    public boolean isIllegalCustomer(Integer customerId){
        validationCheckHistoryRepository.save(
                ValidationCheckHistory.builder()
                        .customerId(customerId)
                        .isIllegal(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }


}
