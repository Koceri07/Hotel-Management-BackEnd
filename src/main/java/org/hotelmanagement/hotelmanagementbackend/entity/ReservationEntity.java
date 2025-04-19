package org.hotelmanagement.hotelmanagementbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hotelmanagement.hotelmanagementbackend.enums.RoomType;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String clientFirstName;
    @Column
    private String clientLastName;
    @Column
    private LocalDateTime reservationDate;
    @Column
    private int roomNumber;
}
