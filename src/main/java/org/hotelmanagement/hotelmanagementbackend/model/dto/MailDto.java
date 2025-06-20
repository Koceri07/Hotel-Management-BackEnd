package org.hotelmanagement.hotelmanagementbackend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailDto {
    private Long id;
    private String mailFrom;
    private List<String> mailTo;
    private String subject;
    private String text;
//    private ReservationDto reservationDto;
}
