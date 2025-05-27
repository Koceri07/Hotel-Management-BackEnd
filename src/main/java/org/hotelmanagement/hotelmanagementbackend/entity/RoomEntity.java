package org.hotelmanagement.hotelmanagementbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hotelmanagement.hotelmanagementbackend.model.enums.RoomType;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int roomNumber;
    @Column
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    @Column
    private boolean isAvailable;
    @Column
    private int pricePerNight;

    @OneToMany(fetch = FetchType.LAZY)
    private List<MarketItemEntity> items;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomEntity that = (RoomEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
