package org.example.quickbookbackend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.quickbookbackend.entity.Hotel;
import org.example.quickbookbackend.entity.Room;

import java.security.PrivateKey;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class HotelDto {
    private int id;
    private String name;
    private String city;
    private String street;
    private String country;
    private int zipCode;
    private int numberOfRooms;
    private LocalDateTime created;
    private LocalDateTime updated;

    public HotelDto(Hotel h) {
        this.id = h.getId();
        this.name = h.getName();
        this.city = h.getCity();
        this.street = h.getStreet();
        this.country = h.getCountry();
        this.zipCode = h.getZipCode();
        this.numberOfRooms = h.getRooms().size();
        this.created = h.getCreated();
        this.updated = h.getUpdated();
    }

}
