package org.hotelmanagement.hotelmanagementbackend.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import org.hotelmanagement.hotelmanagementbackend.entity.ReservationEntity;
import org.hotelmanagement.hotelmanagementbackend.enums.Wristband;
import org.hotelmanagement.hotelmanagementbackend.validation.RoomNumber;

import java.time.LocalDateTime;
import java.util.List;

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
    private Wristband wristband;
    @RoomNumber
    private int roomNumber;
    private boolean reservation_status ;
    private int stay_duration;
    private LocalDateTime check_in;
    private List<ReservationEntity> reservations;
}
