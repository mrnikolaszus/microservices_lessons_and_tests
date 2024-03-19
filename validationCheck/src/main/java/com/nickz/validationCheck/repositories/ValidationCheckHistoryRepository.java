package com.nickz.validationCheck.repositories;

import com.nickz.validationCheck.entity.ValidationCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidationCheckHistoryRepository
        extends JpaRepository<ValidationCheckHistory, Integer> {
}
