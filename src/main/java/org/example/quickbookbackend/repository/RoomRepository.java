package org.example.quickbookbackend.repository;

import org.example.quickbookbackend.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository <Room, Integer> {
}
