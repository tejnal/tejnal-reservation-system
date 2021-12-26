package com.tejnal.reservationsystem.tejnal_reservation_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
public class TejnalReservationSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TejnalReservationSystemApplication.class, args);
    }

}
