package org.example.quickbookbackend.service;

import org.example.quickbookbackend.dto.HotelDto;
import org.example.quickbookbackend.entity.Hotel;
import org.example.quickbookbackend.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;

    public List<HotelDto> getAllHotels() {
        List<Hotel> hotelList = hotelRepository.findAll();
        List<HotelDto> hotelDtoList = new ArrayList<>();

        for(Hotel hotel : hotelList) {
            hotelDtoList.add(new HotelDto(hotel));
        }

        return hotelDtoList;
    }

    public void deleteHotel(int id) {
        hotelRepository.deleteById(id);
    }



}
