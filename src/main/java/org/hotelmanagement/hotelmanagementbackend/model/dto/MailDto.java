package org.hotelmanagement.hotelmanagementbackend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailDto {
    private Long id;
    private String from;
    private String[] to;
    private String subject;
    private String text;
}
