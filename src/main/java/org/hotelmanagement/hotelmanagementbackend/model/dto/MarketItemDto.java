package org.hotelmanagement.hotelmanagementbackend.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hotelmanagement.hotelmanagementbackend.model.enums.ItemCategory;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarketItemDto {
    private Long id;
    private String itemName;
    @NotNull
    private Double itemPrice;
    @Positive
    private Integer stock;
    private ItemCategory itemCategory;
    private RoomDto room;
}
