package org.hotelmanagement.hotelmanagementbackend.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hotelmanagement.hotelmanagementbackend.entity.ClientEntity;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {

    private Long id;
    private String clientFirstName;
    private String clientLastName;
    private LocalDateTime reservationDate;
    private int roomNumber;
    private ClientEntity client;
}
