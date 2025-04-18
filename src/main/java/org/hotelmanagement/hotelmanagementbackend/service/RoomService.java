package org.hotelmanagement.hotelmanagementbackend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hotelmanagement.hotelmanagementbackend.dto.RoomDto;
import org.hotelmanagement.hotelmanagementbackend.entity.RoomEntity;
import org.hotelmanagement.hotelmanagementbackend.exception.NotFoundException;
import org.hotelmanagement.hotelmanagementbackend.mapper.RoomMapper;
import org.hotelmanagement.hotelmanagementbackend.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public void createRoom(RoomDto roomDto){
        log.info("Action.createRoom.start for room number {}", roomDto.getRoomNumber());
        roomRepository.save(RoomMapper.INSTANCE.toEntity(roomDto));
        log.info("Action.createRoom.end for room number {}", roomDto.getRoomNumber());
    }

    public List<RoomDto> getAllRooms(){
        log.info("Action.getAllRooms.start");
        List<RoomDto> rooms = roomRepository.findAll()
                .stream()
                .map(RoomMapper.INSTANCE::toDto)
                .toList();
        log.info("Action.getAllRooms.end");
        return rooms;
    }

    public RoomDto getRoomById(Long id){
        log.info("Action.getRoomById.start for id {}", id);
        var roomEntity = roomRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id Not Found"));
        var roomDto = RoomMapper.INSTANCE.toDto(roomEntity);
        log.info("Action.getRoomById.end for id {}", id);
        return roomDto;
    }

    public void deleteRoomById(Long id){
        log.info("Action.deleteRoomById.start for id {}",id);
        roomRepository.deleteById(id);
        log.info("Action.deleteRoomById.end for id {}", id);
    }

    public int findEmtyRoom(){
        log.info("Action.findEmtyRoom.start");
        int roomNumber = roomRepository.findFirstEmptyRoom();
        roomRepository.changeIsAvailableFalse();
        log.info("Action.findEmtyRoom.end");
        return roomNumber;
    }
}
