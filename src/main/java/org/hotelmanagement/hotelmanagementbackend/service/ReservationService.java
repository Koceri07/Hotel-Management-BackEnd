package org.hotelmanagement.hotelmanagementbackend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hotelmanagement.hotelmanagementbackend.dto.ReservationDto;
import org.hotelmanagement.hotelmanagementbackend.entity.ReservationEntity;
import org.hotelmanagement.hotelmanagementbackend.exception.NotFoundException;
import org.hotelmanagement.hotelmanagementbackend.mapper.ReservationMapper;
import org.hotelmanagement.hotelmanagementbackend.repository.ReservationResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationResponse reservationResponse;

    public void createReservation(ReservationDto reservationDto){
        log.info("Action.createReservation for name {}", reservationDto.getClientFirstName());
        boolean checkReservationDate = isHaveReservationDate(reservationDto.getReservationDate());
        boolean checkReservedRoom = isHaveReservedRoom(reservationDto.getRoomNumber());

        if (checkReservedRoom &&  checkReservationDate){

        }


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

    public boolean isHaveReservationDate(LocalDateTime localDateTime){
        log.info("Action.isHaveReservationDate.start for date {}", localDateTime);
        List<LocalDateTime> roomNumbers = reservationResponse.findAllReservationDate();

        log.info("Actions");
        boolean isHave = roomNumbers.stream()
                .noneMatch(localDateTime1 -> localDateTime1.equals(localDateTime));
        if (isHave){
            log.info("Actions.isHaveReservationDate.end for date {}", localDateTime);
            return false;
        }
        log.info("Action.isHaveReservationDate.end for date {}", localDateTime);
        return true;
    }
    public boolean isHaveReservedRoom(int roomNumber){
        log.info("Action.isHaveReservedRoom.start for room number {}", roomNumber);
        List<Integer> roomNumbers = reservationResponse.findAllReservedRooms();

        boolean isHave = roomNumbers.stream()
                .noneMatch(number -> number.equals(roomNumber));
        if (isHave){
            log.info("Action.isHaveReservedRoom.end for room number {}", roomNumber);
            return false;
        }
        log.info("Action.isHaveReservedRoom.end for room number {}", roomNumber);
        return true;
    }

    public void foundCheckOutDate(int stayDuration){

    }
}
