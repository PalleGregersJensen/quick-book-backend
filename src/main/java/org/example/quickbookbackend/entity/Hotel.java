package org.example.quickbookbackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String street;
    private String city;
    private String country;
    private int zipCode;

    @OneToMany(mappedBy = "hotel")
    @JsonBackReference
    private List<Room> rooms;

    private LocalDateTime created;
    private LocalDateTime updated;
}
