package com.tejnal.reservationsystem.tejnal_reservation_system.controller;

import com.tejnal.reservationsystem.tejnal_reservation_system.model.Reservation;
import com.tejnal.reservationsystem.tejnal_reservation_system.model.User;
import com.tejnal.reservationsystem.tejnal_reservation_system.service.ReservationService;
import com.tejnal.reservationsystem.tejnal_reservation_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Set;


@Controller
// this will return pre rendered views/HTML
public class PageController {


   final  UserService userService;
  final   ReservationService reservationService;

    public PageController(UserService userService, ReservationService reservationService) {
        this.userService = userService;
        this.reservationService = reservationService;
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/reservations")
    public String reservations(Model model, HttpSession session){

        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
        User user = userService.getUserByUsername(name);

    if (user != null) {
      session.setAttribute("user", user);
        // Empty reservation object in case the user creates a new reservation
      Reservation reservation = new Reservation();
      model.addAttribute("reservation", reservation);
      return "reservations";
        }
    return "index";


    }

    @PostMapping("/reservation-submit")
    public String reservationSubmit(@ModelAttribute Reservation reservation, @SessionAttribute("user") User user) {

        assert user != null;
        reservation.setUser(user);
        reservationService.create(reservation);
        Set<Reservation> userReservations = user.getReservations();
        userReservations.add(reservation);
        user.setReservations(userReservations);
        userService.update(user.getId(), user);

        return "redirect:/reservations";


    }

}
