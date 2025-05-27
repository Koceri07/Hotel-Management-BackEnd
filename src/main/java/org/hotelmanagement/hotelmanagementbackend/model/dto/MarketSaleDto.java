package org.hotelmanagement.hotelmanagementbackend.model.dto;

import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hotelmanagement.hotelmanagementbackend.entity.MarketItemEntity;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarketSaleDto {
    private Long id;
    private int roomNumber;
    private List<MarketItemDto> items;
    private BigDecimal totalPrice;
}

/*
{
  "id": 100,
  "roomId": 100,
  "items": [
    {
      "id": 100,
      "itemName": "Something",
      "itemPrice": 76341018.676757810000,
      "stock": 100,
      "itemCategory": "FOODS"
    }
  ],
  "totalPrice": 85596046.447753900000
}
 */
