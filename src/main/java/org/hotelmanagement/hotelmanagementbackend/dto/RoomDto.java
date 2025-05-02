package org.hotelmanagement.hotelmanagementbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hotelmanagement.hotelmanagementbackend.enums.RoomType;
import org.hotelmanagement.hotelmanagementbackend.validation.RoomNumber;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    @RoomNumber
    private int roomNumber;
    private RoomType roomType;
    private boolean isAvailable;
    private int pricePerNight;
}
