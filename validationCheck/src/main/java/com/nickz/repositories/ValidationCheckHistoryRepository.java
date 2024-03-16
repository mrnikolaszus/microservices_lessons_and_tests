package com.nickz.repositories;

import com.nickz.entity.ValidationCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidationCheckHistoryRepository
        extends JpaRepository<ValidationCheckHistory, Integer> {
}
