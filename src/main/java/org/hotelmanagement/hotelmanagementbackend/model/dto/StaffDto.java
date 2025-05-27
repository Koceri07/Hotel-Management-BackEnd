package org.hotelmanagement.hotelmanagementbackend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hotelmanagement.hotelmanagementbackend.model.enums.Possitions;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDto {
    private Long id;

    private String firstName;
    private String lastName;
    private Possitions possitions;
    private String phoneNumber;
    private BigDecimal salary;
    private String email;
    private LocalDateTime hireDate;
}

