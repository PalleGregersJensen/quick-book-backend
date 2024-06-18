package org.example.quickbookbackend.controller;

import org.example.quickbookbackend.dto.HotelDto;
import org.example.quickbookbackend.entity.Hotel;
import org.example.quickbookbackend.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
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

}
