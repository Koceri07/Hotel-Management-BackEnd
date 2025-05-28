package org.hotelmanagement.hotelmanagementbackend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hotelmanagement.hotelmanagementbackend.model.enums.Positions;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDto {
    private Long id;

    private String firstName;
    private String lastName;
    private Positions positions;
    private String phoneNumber;
    private BigDecimal salary;
    private String email;
    private LocalDateTime hireDate;
}

