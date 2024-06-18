package org.example.quickbookbackend.repository;

import org.example.quickbookbackend.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}
