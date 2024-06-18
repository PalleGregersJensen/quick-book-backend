package org.example.quickbookbackend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.quickbookbackend.entity.Hotel;
import org.example.quickbookbackend.entity.Room;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class RoomDto {
 private int id;
 private int roomNumber;
 private int numberOfBeds;
 private Hotel hotel;
 private double price;
 private LocalDateTime created;
 private LocalDateTime updated;

 public RoomDto(Room r) {
     this.id = r.getId();
     this.roomNumber = r.getRoomNumber();
     this.numberOfBeds = r.getNumberOfBeds();
     this.hotel = r.getHotel();
     this.price = r.getPrice();
     this.created = r.getCreated();
     this.updated = r.getUpdated();
 }
}
