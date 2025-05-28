package org.hotelmanagement.hotelmanagementbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hotelmanagement.hotelmanagementbackend.model.enums.Positions;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "staffs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StaffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Positions positions;
    private String phoneNumber;
    private String email;
    private BigDecimal salary;
    private LocalDateTime hireDate;

}
