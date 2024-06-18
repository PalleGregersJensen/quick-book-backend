package org.example.quickbookbackend.controller;

import org.example.quickbookbackend.dto.HotelDto;
import org.example.quickbookbackend.entity.Hotel;
import org.example.quickbookbackend.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    HotelService hotelService;

    //Get all hotels
    @GetMapping
    public List<HotelDto> getAllHotels() {
        return hotelService.getAllHotels();
    }

    //Delete hotel by id
    @DeleteMapping("/{id}")
    public String deleteHotel(@PathVariable int id) {
        hotelService.deleteHotel(id);
        return "Hotel with ID: " + id + " has been deleted";
    }

    //Update hotel by id
    @PutMapping("/{id}")
    public Hotel updateHotel (@PathVariable int id, @RequestBody Hotel hotel) {
        return hotelService.updateHotel(id, hotel);
    }
}
