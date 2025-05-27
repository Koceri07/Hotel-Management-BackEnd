package org.hotelmanagement.hotelmanagementbackend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hotelmanagement.hotelmanagementbackend.model.enums.RoomType;
import org.hotelmanagement.hotelmanagementbackend.validation.RoomNumber;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    @RoomNumber
    private int roomNumber;
    private RoomType roomType;
    private boolean isAvailable;
    private int pricePerNight;
    private List<MarketItemDto> items;
}
