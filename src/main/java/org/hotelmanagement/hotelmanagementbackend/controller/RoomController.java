package org.hotelmanagement.hotelmanagementbackend.controller;

import lombok.RequiredArgsConstructor;
import org.hotelmanagement.hotelmanagementbackend.model.dto.RoomDto;
import org.hotelmanagement.hotelmanagementbackend.model.response.ApiResponse;
import org.hotelmanagement.hotelmanagementbackend.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/rooms")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(RoomDto roomDto){
        roomService.createRoom(roomDto);
    }

    @GetMapping
    public ApiResponse getAll(){
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public ApiResponse getById(@PathVariable Long id){
        return roomService.getRoomById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        roomService.deleteRoomById(id);
    }
}
