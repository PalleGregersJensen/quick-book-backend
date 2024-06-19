package org.example.quickbookbackend.service;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.example.quickbookbackend.dto.HotelDto;
import org.example.quickbookbackend.entity.Hotel;
import org.example.quickbookbackend.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;

    //Get all hotels
    public List<HotelDto> getAllHotels() {
        List<Hotel> hotelList = hotelRepository.findAll();
        List<HotelDto> hotelDtoList = new ArrayList<>();

        for(Hotel hotel : hotelList) {
            hotelDtoList.add(new HotelDto(hotel));
        }

        return hotelDtoList;
    }

    //Get hotel by id
    public HotelDto getHotelById(int id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        if (hotel.isPresent()) {
            return new HotelDto(hotel.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel not found");
        }
    }


    //Delete hotel by ID
    public void deleteHotel(int id) {
        hotelRepository.deleteById(id);
    }

    //Update hotel by ID
    public Hotel updateHotel(int id, Hotel updatedHotel) {
        // Check if hotel with that ID exists in database
        Optional<Hotel> existingHotelOptional = hotelRepository.findById(id);

        if (existingHotelOptional.isPresent()) {
            // If hotel exists, update the rest of the properties
            Hotel existingHotel = existingHotelOptional.get();
            //existingHotel.setCreated(updatedHotel.getCreated());
            existingHotel.setUpdated(LocalDateTime.now());
            existingHotel.setCity(updatedHotel.getCity());
            existingHotel.setName(updatedHotel.getName());
            existingHotel.setCountry(updatedHotel.getCountry());
            existingHotel.setStreet(updatedHotel.getStreet());
            existingHotel.setZipCode(updatedHotel.getZipCode());

            // Save updated hotel in database
            return hotelRepository.save(existingHotel);
        } else {
            // If hotel does not exist in database, throw error
            throw new RuntimeException("Hotel with ID: " + id + " not found");
        }
    }

}
