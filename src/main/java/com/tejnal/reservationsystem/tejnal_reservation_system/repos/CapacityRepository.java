package com.tejnal.reservationsystem.tejnal_reservation_system.repos;


import com.tejnal.reservationsystem.tejnal_reservation_system.model.AmenityType;
import com.tejnal.reservationsystem.tejnal_reservation_system.model.Capacity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CapacityRepository extends JpaRepository<Capacity, Long> {

    Capacity findByAmenityType(AmenityType amenityType);
}
