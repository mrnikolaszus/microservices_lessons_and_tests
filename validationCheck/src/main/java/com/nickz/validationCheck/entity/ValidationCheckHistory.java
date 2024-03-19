package com.nickz.validationCheck.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ValidationCheckHistory {

    @Id
    @SequenceGenerator(
            name = "valid_id_sequence",
            sequenceName = "valid_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "valid_id_sequence"
    )
    private Integer id;
    private Integer customerId;
    private Boolean isIllegal;
    private LocalDateTime createdAt;




}
