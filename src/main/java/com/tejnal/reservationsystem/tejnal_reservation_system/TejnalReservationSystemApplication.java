package com.tejnal.reservationsystem.tejnal_reservation_system;

import com.tejnal.reservationsystem.tejnal_reservation_system.model.AmenityType;
import com.tejnal.reservationsystem.tejnal_reservation_system.model.Capacity;
import com.tejnal.reservationsystem.tejnal_reservation_system.model.Reservation;
import com.tejnal.reservationsystem.tejnal_reservation_system.model.User;
import com.tejnal.reservationsystem.tejnal_reservation_system.repos.CapacityRepository;
import com.tejnal.reservationsystem.tejnal_reservation_system.repos.ReservationRepository;
import com.tejnal.reservationsystem.tejnal_reservation_system.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
public class TejnalReservationSystemApplication {

    private Map<AmenityType, Integer> initialCapacities =
            new HashMap<>() {
                {
                    put(AmenityType.GYM, 20);
                    put(AmenityType.POOL, 4);
                    put(AmenityType.SAUNA, 1);
                }
            };

    public static void main(String[] args) {
        SpringApplication.run(TejnalReservationSystemApplication.class, args);
    }


    @Bean
    public CommandLineRunner loadData(UserRepository userRepository, ReservationRepository reservationRepository, CapacityRepository capacityRepository) {

        return (args) -> {
            userRepository.save(
                    new User("Tej Nalluri", "tejnal", bCryptPasswordEncoder().encode("12345")));

            for (AmenityType amenityType : initialCapacities.keySet()) {
                capacityRepository.save(new Capacity(amenityType, initialCapacities.get(amenityType)));
            }
        };

    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
