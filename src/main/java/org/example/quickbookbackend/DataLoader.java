/*package org.example.quickbookbackend;

import org.example.quickbookbackend.entity.Hotel;
import org.example.quickbookbackend.entity.Room;
import org.example.quickbookbackend.repository.HotelRepository;
import org.example.quickbookbackend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataLoader implements CommandLineRunner {

    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public DataLoader(HotelRepository hotelRepository, RoomRepository roomRepository) {
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public void run(String... args) {
        // Generate 250 dummy hotels
        List<Hotel> hotels = generateDummyHotels(250);

        // Save hotels to get generated IDs
        hotels = hotelRepository.saveAll(hotels);

        // Generate rooms for each hotel
        for (Hotel hotel : hotels) {
            List<Room> rooms = generateDummyRooms(hotel);
            roomRepository.saveAll(rooms);
        }
    }

    private List<Hotel> generateDummyHotels(int numberOfHotels) {
        List<Hotel> hotels = new ArrayList<>();
        for (int i = 1; i <= numberOfHotels; i++) {
            Hotel hotel = new Hotel();
            hotel.setName("Hotel " + i);
            hotel.setStreet("Street " + i);
            hotel.setCity("City " + i);
            hotel.setCountry("Country " + i);
            hotel.setZipCode(1000 + i);

            hotel.setCreated(LocalDateTime.now());
            hotel.setUpdated(LocalDateTime.now());

            hotels.add(hotel);
        }
        return hotels;
    }

    private List<Room> generateDummyRooms(Hotel hotel) {
        List<Room> rooms = new ArrayList<>();
        Random random = new Random();
        int numberOfRooms = random.nextInt(31) + 10; // Random number of rooms between 10 and 40

        for (int i = 1; i <= numberOfRooms; i++) {
            Room room = new Room();
            room.setRoomNumber(i);
            room.setNumberOfBeds(random.nextInt(4) + 1); // Random number of beds between 1 and 4
            room.setHotel(hotel);
            room.setPrice(random.nextDouble() * 1000 + 500); // Random price between 500 and 1500

            room.setCreated(LocalDateTime.now());
            room.setUpdated(LocalDateTime.now());

            rooms.add(room);
        }
        return rooms;
    }
}

 */