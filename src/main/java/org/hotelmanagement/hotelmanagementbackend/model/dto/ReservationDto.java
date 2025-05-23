package org.hotelmanagement.hotelmanagementbackend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private ClientDto client;
    private MailDto mailDto;
}
