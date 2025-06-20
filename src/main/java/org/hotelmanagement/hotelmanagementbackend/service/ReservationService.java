package org.hotelmanagement.hotelmanagementbackend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hotelmanagement.hotelmanagementbackend.model.dto.ReservationDto;
import org.hotelmanagement.hotelmanagementbackend.entity.ReservationEntity;
import org.hotelmanagement.hotelmanagementbackend.exception.NotFoundException;
import org.hotelmanagement.hotelmanagementbackend.exception.ReservationAlreadyExists;
import org.hotelmanagement.hotelmanagementbackend.mapper.ReservationMapper;
import org.hotelmanagement.hotelmanagementbackend.model.factory.CheckFactory;
import org.hotelmanagement.hotelmanagementbackend.model.response.ApiResponse;
import org.hotelmanagement.hotelmanagementbackend.repository.ReservationResponse;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReservationService implements CheckFactory{
    private final ReservationResponse reservationResponse;
    private final ClientService clientService;


    public void createReservation(ReservationDto reservationDto){
        log.info("Action.createReservation for name {}", reservationDto.getClientFirstName());
        boolean checkReservationDate = isHaveReservationDateFactory(reservationDto.getReservationDate());
        boolean checkReservedRoom = isHaveReservedRoomFactory(reservationDto.getRoomNumber());

        if (checkReservedRoom &&  checkReservationDate){
            log.error("Action.createReservation.error for name {}", reservationDto.getClientFirstName());
            throw new ReservationAlreadyExists("This Reservation Already Exits");
        }
        reservationDto.getClient().setActive(false);
        ReservationEntity reservationEntity = ReservationMapper.INSTANCE.toEntity(reservationDto);
        reservationResponse.save(reservationEntity);
        clientService.createClient(reservationDto.getClient());
        log.info("Action.createReservation.end for name {}",reservationDto.getClientFirstName());
    }

    public ApiResponse getReservationById(Long id){
        log.info("Action.getReservationById.start for id {}",id);
        var reservationEntity = reservationResponse.findById(id)
                .orElseThrow(() -> new NotFoundException("Id Not Found"));
        var reservationDto = ReservationMapper.INSTANCE.toDto(reservationEntity);
        ApiResponse apiResponse = new ApiResponse(reservationDto);
        log.info("Action.getReservationById.end for id {}",id);
        return apiResponse;
    }

    public ApiResponse getAllReservations(){
        log.info("Action.getAllReservations.start");
        var reservationDto = reservationResponse.findAll()
                .stream()
                .map(ReservationMapper.INSTANCE::toDto)
                .toList();
        ApiResponse apiResponse = new ApiResponse(reservationDto);
        log.info("Action.getAllReservations.end");
        return apiResponse;
    }

    public void deleteReservationById(Long id){
        log.info("Action.deleteReservationById.start for id {}",id);
        reservationResponse.deleteById(id);
        log.info("Action.deleteReservationById.end for id {}",id);
    }

//    public boolean isHaveReservationDate(LocalDateTime localDateTime){
//        log.info("Action.isHaveReservationDate.start for date {}", localDateTime);
//
//        List<LocalDateTime> reservationDates = reservationResponse.findAllReservationDate();
//
//        log.info("Actions");
//        boolean isHave = reservationDates.stream()
//                .noneMatch(date -> date.toLocalDate().equals(localDateTime.toLocalDate()));
//
//        if (isHave){
//            log.info("Actions.isHaveReservationDate.end for date {}", localDateTime);
//            return false;
//        }
//        log.info("Action.isHaveReservationDate.end for date {}", localDateTime);
//        return true;
//    }

//    public boolean isHaveReservedRoom(int roomNumber){
//        log.info("Action.isHaveReservedRoom.start for room number {}", roomNumber);
//        List<Integer> roomNumbers = reservationResponse.findAllReservedRooms();
//
//        boolean isHave = roomNumbers.stream()
//                .noneMatch(number -> number.equals(roomNumber));
//        if (isHave){
//            log.info("Action.isHaveReservedRoom.end for room number {}", roomNumber);
//            return false;
//        }
//        log.info("Action.isHaveReservedRoom.end for room number {}", roomNumber);
//        return true;
//    }


    @Override
    public boolean isHaveReservedRoomFactory(int roomNumber) {
        log.info("Action.idReserved.start for room number {}", roomNumber);
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

    @Override
    public boolean isHaveReservationDateFactory(LocalDateTime localDateTime) {
        log.info("Action.isHaveReservationDate.start for date {}", localDateTime);

        List<LocalDateTime> reservationDates = reservationResponse.findAllReservationDate();

        log.info("Actions");
        boolean isHave = reservationDates.stream()
                .noneMatch(date -> date.toLocalDate().equals(localDateTime.toLocalDate()));

        if (isHave){
            log.info("Actions.isHaveReservationDate.end for date {}", localDateTime);
            return false;
        }
        log.info("Action.isHaveReservationDate.end for date {}", localDateTime);
        return true;
    }
}
