package com.tejnal.reservationsystem.tejnal_reservation_system.repos;

import com.tejnal.reservationsystem.tejnal_reservation_system.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
