package com.rahuln.springmicroservices.fraud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FraudCheckHistory {
    @Id
    @SequenceGenerator(
            name = "fraud_sequence",
            sequenceName = "fraud_sequence"
    )
    @GeneratedValue(
            generator = "fraud_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Integer id;
    private Integer customerId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;
}
