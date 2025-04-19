package org.hotelmanagement.hotelmanagementbackend.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    @NotNull
    private Long id;
    @Length(min = 3,max = 16)
    private String firstName;
    @Length(min = 3,max = 32)
    private String lastName;

    private boolean isActive;
    private String fincode;
    private String wristband;
    private int roomNumber;
    private boolean reservation_status ;
    private int stay_duration;
    private LocalDateTime check_in;
}
