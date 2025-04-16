package org.hotelmanagement.hotelmanagementbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    private int roomNumber;
    private String roomType;
    private boolean isAvailable;
    private Double pricePerNight;
}
