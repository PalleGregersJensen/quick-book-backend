package org.example.quickbookbackend.controller;

import jakarta.annotation.PostConstruct;
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

    //Get hotel by id
    @GetMapping("{id}")
    public HotelDto getHotelByID(@PathVariable int id) {
        return hotelService.getHotelById(id);
    }

    //Delete hotel by id
    @DeleteMapping("/{id}")
    public String deleteHotel(@PathVariable int id) {
        hotelService.deleteHotel(id);
        return "Hotel with ID: " + id + " has been deleted";
    }

    //Post hotel to database
    @PostMapping
    public Hotel createHotel(@RequestBody Hotel hotel) {
        return hotelService.createNewHotel(hotel);
    }

    //Update hotel by id
    @PutMapping("/{id}")
    public Hotel updateHotel (@PathVariable int id, @RequestBody Hotel hotel) {
        return hotelService.updateHotel(id, hotel);
    }
}
