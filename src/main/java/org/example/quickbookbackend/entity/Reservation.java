package org.example.quickbookbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate reservationDate;
    private LocalDateTime created;
    private LocalDateTime updated;

    @JoinColumn(name = "guest_id_fk")
    @ManyToOne
    private Guest guest;

    @JoinColumn(name = "room_id_fk")
    @ManyToOne
    private Room room;
}
