package org.hotelmanagement.hotelmanagementbackend.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.hotelmanagement.hotelmanagementbackend.model.dto.ReservationDto;
import org.hotelmanagement.hotelmanagementbackend.model.response.ApiResponse;
import org.hotelmanagement.hotelmanagementbackend.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("v1/reservation")
@RequiredArgsConstructor
@OpenAPIDefinition(tags = {
        @Tag(name = "Reservations", description = "Reservations operations")
})
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ReservationDto reservationDto){
        reservationService.createReservation(reservationDto);
    }

    @GetMapping("/{id}")
    public ApiResponse getById(@PathVariable Long id){
        return reservationService.getReservationById(id);
    }

    @GetMapping
    public ApiResponse getAll(){
        return reservationService.getAllReservations();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        reservationService.deleteReservationById(id);
    }

    @GetMapping("/{localDateTime}")
    public void checkReservation(@PathVariable LocalDateTime localDateTime){
        reservationService.isHaveReservationDateFactory(localDateTime);
    }

}
