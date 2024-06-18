package org.example.quickbookbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int roomNumber;
    private int numberOfBeds;

    @ManyToOne
    @JoinColumn(name="hotel_id_fk")
    private Hotel hotel;

    private double price;
    private LocalDateTime created;
    private LocalDateTime updated;
}
