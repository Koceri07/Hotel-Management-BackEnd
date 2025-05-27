package org.hotelmanagement.hotelmanagementbackend.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hotelmanagement.hotelmanagementbackend.entity.ReservationEntity;
import org.hotelmanagement.hotelmanagementbackend.model.dto.ClientDto;
import org.hotelmanagement.hotelmanagementbackend.entity.ClientEntity;
import org.hotelmanagement.hotelmanagementbackend.exception.NotFoundException;
import org.hotelmanagement.hotelmanagementbackend.exception.ReservationAlreadyExists;
import org.hotelmanagement.hotelmanagementbackend.mapper.ClientMapper;
import org.hotelmanagement.hotelmanagementbackend.mapper.DeletedClientMapper;
import org.hotelmanagement.hotelmanagementbackend.model.factory.CheckFactory;
import org.hotelmanagement.hotelmanagementbackend.model.response.ApiResponse;
import org.hotelmanagement.hotelmanagementbackend.repository.ClientRepository;
import org.hotelmanagement.hotelmanagementbackend.repository.DeletedClientRepository;
import org.hotelmanagement.hotelmanagementbackend.repository.ReservationResponse;
import org.hotelmanagement.hotelmanagementbackend.repository.RoomRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientService implements CheckFactory {
    private final ClientRepository clientRepository;
    private final ReservationResponse reservationResponse;
    private final RoomService roomService;
    private final DeletedClientRepository deletedClientRepository;
    private final RoomRepository roomRepository;
    private final MarketSaleService marketSaleService;


    public void createClient(ClientDto clientDto){
        log.info("Action.createClient.start for name {}", clientDto.getFirstName());
        if (isReserved(clientDto.getCheck_in(),clientDto.getRoomNumber())) {
            throw new ReservationAlreadyExists("This Room or Date is Reserved");
        }
        try {
            clientDto.setRoomNumber(roomService.findEmtyRoom());
        } catch (Exception e) {
            throw new NotFoundException("Not Found Empty Room");
        }
        clientDto.setActive(true);
        ClientEntity clientEntity = ClientMapper.INSTANCE.toEntity(clientDto);
        clientRepository.save(clientEntity);
        log.info("Action.createClient.end for name {}", clientDto.getFirstName());
    }

    public ApiResponse getAllClients(){
        log.info("Action.getAllClients.start");
        List<ClientDto> clients =  clientRepository.findAll()
                .stream()
                .map(ClientMapper.INSTANCE::toDto)
                .toList();
        ApiResponse apiResponse = new ApiResponse(clients);
        log.info("Action.getAllClients.end");
        return apiResponse;
    }

    public ApiResponse getClientById(Long id){
        log.info("Action.getClientById.start for id {}", id);
        var clientEntity =clientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id Not Found"));
        ClientDto clientDto = ClientMapper.INSTANCE.toDto(clientEntity);
        ApiResponse apiResponse = new ApiResponse(clientDto);
        log.info("Actionget.ClientById.end for id {}", id);
        return apiResponse;
    }

    //
    @Transactional
    public void deleteClientById(Long id){
        log.info("Action.deleteClientById.start for id {}", id);
        var clientDto = getClientDtoById(id);
        var deletedClient = DeletedClientMapper.INSTANCE.dtoToDeletedClient(clientDto);
        deletedClientRepository.save(deletedClient);
        var roomNumber = clientDto.getRoomNumber();
        roomRepository.changeIsAvailableTrueWithId(roomNumber);
        clientRepository.deleteById(id);
        log.info("Action.deleteClientById.end for id {}", id);
    }

    public ClientDto getClientDtoById(Long id){
        log.info("Action.getClientById.start for id {}", id);
        var clientEntity =clientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id Not Found"));
        ClientDto clientDto = ClientMapper.INSTANCE.toDto(clientEntity);
        log.info("Actionget.ClientById.end for id {}", id);
        return clientDto;
    }

    @Transactional
    public void checkOut(Long id){
        log.info("Action.checkOut.start for id {}", id);
        clientRepository.deactivateClient(id);
//        var roomNumber = getClientDtoById(id).getRoomNumber();
//        marketSaleService.getTotalPrice(roomNumber);
        log.info("Action.checkOut.end for id {}", id);
    }

    public boolean isReserved(LocalDateTime localDateTime, int roomNumber){
        var reservationDate = isHaveReservationDateFactory(localDateTime);
        var reservedRoom = isHaveReservedRoomFactory(roomNumber);

        if (reservedRoom || reservationDate){
            return true;
        }
        return false;
    }


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

    @Scheduled(fixedDelay = 86400000)
    public void checkReservedRooms() {
        List<ReservationEntity> reservations = reservationResponse.findAll();

        for (ReservationEntity reservation : reservations) {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime reservationTime = reservation.getReservationDate();


            if (now.toLocalDate().equals(reservationTime.toLocalDate())) {
                reservation.getClient().setActive(true);
                clientRepository.save(reservation.getClient());
            }
        }
    }
}
