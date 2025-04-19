package org.hotelmanagement.hotelmanagementbackend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hotelmanagement.hotelmanagementbackend.dto.ReservationDto;
import org.hotelmanagement.hotelmanagementbackend.entity.ReservationEntity;
import org.hotelmanagement.hotelmanagementbackend.exception.NotFoundException;
import org.hotelmanagement.hotelmanagementbackend.mapper.ReservationMapper;
import org.hotelmanagement.hotelmanagementbackend.repository.ReservationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationResponse reservationResponse;

    public void createReservation(ReservationDto reservationDto){
        log.info("Action.createReservation for name {}", reservationDto.getClientFirstName());
        ReservationEntity reservationEntity = ReservationMapper.INSTANCE.toEntity(reservationDto);
        reservationResponse.save(reservationEntity);
        log.info("Action.createReservation.end for name {}",reservationDto.getClientFirstName());
    }

    public ReservationDto getReservationById(Long id){
        log.info("Action.getReservationById.start for id {}",id);
        var reservationEntity = reservationResponse.findById(id)
                .orElseThrow(() -> new NotFoundException("Id Not Found"));
        var reservationDto = ReservationMapper.INSTANCE.toDto(reservationEntity);
        log.info("Action.getReservationById.end for id {}",id);
        return reservationDto;
    }

    public List<ReservationDto> getAllReservations(){
        log.info("Action.getAllReservations.start");
        var reservationDto = reservationResponse.findAll()
                .stream()
                .map(ReservationMapper.INSTANCE::toDto)
                .toList();
        log.info("Action.getAllReservations.end");
        return reservationDto;
    }

    public void deleteReservationById(Long id){
        log.info("Action.deleteReservationById.start for id {}",id);
        reservationResponse.deleteById(id);
        log.info("Action.deleteReservationById.end for id {}",id);
    }
}
