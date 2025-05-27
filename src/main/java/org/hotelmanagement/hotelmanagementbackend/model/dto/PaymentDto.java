package org.hotelmanagement.hotelmanagementbackend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    private Long id;
    private String cartNumber;
    private LocalDateTime expirationDate;
    private String cvv;
    private BigDecimal amount;
}
