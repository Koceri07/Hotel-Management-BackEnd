package org.hotelmanagement.hotelmanagementbackend.controller;

import lombok.RequiredArgsConstructor;
import org.hotelmanagement.hotelmanagementbackend.dto.ReservationDto;
import org.hotelmanagement.hotelmanagementbackend.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("v1/reservation")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(ReservationDto reservationDto){
        reservationService.createReservation(reservationDto);
    }

    @GetMapping("/{id}")
    public ReservationDto getById(@PathVariable Long id){
        return reservationService.getReservationById(id);
    }

    @GetMapping
    public List<ReservationDto> getAll(){
        return reservationService.getAllReservations();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        reservationService.deleteReservationById(id);
    }

    @GetMapping("/{localDateTime}")
    public void checkReservation(@PathVariable LocalDateTime localDateTime){
        reservationService.isHaveReservationDate(localDateTime);
    }

}
