package org.hotelmanagement.hotelmanagementbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hotelmanagement.hotelmanagementbackend.model.enums.ItemCategory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "market_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MarketItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private BigDecimal itemPrice;
    private Integer stock;
    private ItemCategory itemCategory;

    @ManyToMany(mappedBy = "items")
    private List<MarketSaleEntity> sales;

    @ManyToOne
    private RoomEntity room;

    @CreationTimestamp
    private LocalDateTime createAt;

    @UpdateTimestamp
    private LocalDateTime updateAt;
}
