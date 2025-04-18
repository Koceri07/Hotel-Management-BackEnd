package org.hotelmanagement.hotelmanagementbackend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hotelmanagement.hotelmanagementbackend.dto.ClientDto;
import org.hotelmanagement.hotelmanagementbackend.entity.ClientEntity;
import org.hotelmanagement.hotelmanagementbackend.exception.NotFoundException;
import org.hotelmanagement.hotelmanagementbackend.mapper.ClientMapper;
import org.hotelmanagement.hotelmanagementbackend.repository.ClientRepository;
import org.hotelmanagement.hotelmanagementbackend.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final RoomRepository roomRepository;
    private final RoomService roomService;

    public void createClient(ClientDto clientDto){
        log.info("Action.createClient.start for name {}", clientDto.getFirstName());
        clientDto.setRoomNumber(roomService.findEmtyRoom());
        ClientEntity clientEntity = ClientMapper.INSTANCE.toEntity(clientDto);
        clientRepository.save(clientEntity);
        log.info("Action.createClient.end for name {}", clientDto.getFirstName());
    }

    public List<ClientDto> getAllClients(){
        log.info("Action.getAllClients.start");
        List<ClientDto> clients =  clientRepository.findAll()
                .stream()
                .map(ClientMapper.INSTANCE::toDto)
                .toList();
        log.info("Action.getAllClients.end");
        return clients;
    }

    public ClientDto getClientById(Long id){
        log.info("Action.getClientById.start for id {}", id);
        var clientEntity =clientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id Not Found"));
        ClientDto clientDto = ClientMapper.INSTANCE.toDto(clientEntity);
        log.info("Actionget.ClientById.end for id {}", id);
        return clientDto;
    }

    //
    public void deleteClientById(Long id){
        log.info("Action.deleteClientById.start for id {}", id);
        clientRepository.deleteById(id);
        log.info("Action.deleteClientById.end for id {}", id);
    }




}
