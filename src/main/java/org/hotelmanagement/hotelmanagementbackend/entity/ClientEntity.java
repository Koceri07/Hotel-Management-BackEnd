package org.hotelmanagement.hotelmanagementbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hotelmanagement.hotelmanagementbackend.enums.Wristband;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "clients")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity {
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
    @Enumerated(EnumType.STRING)
    private Wristband wristband;
    @Column
    private int roomNumber;
    @Column
    private boolean reservation_status;
    @Column
    private int stay_duration;
    @Column
    private LocalDateTime check_in;
    @Column
    private boolean isActive;

    @CreationTimestamp
    private LocalDateTime createAt;

//    @OneToMany
//    @JoinColumn(name = "reservation_id")
//    private List<ReservationEntity> reservations;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<ReservationEntity> reservations;


//    @OneToOne
//    private CommentEntity comment;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity that = (ClientEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
