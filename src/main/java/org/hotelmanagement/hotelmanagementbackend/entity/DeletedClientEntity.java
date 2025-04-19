package org.hotelmanagement.hotelmanagementbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "deleted_clients")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeletedClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String fincode;
    @Column
    private String wristband;
    @Column
    private int roomNumber;
    @Column
    private int stay_duration;
    @Column
    private LocalDateTime check_in;
}
