package org.hotelmanagement.hotelmanagementbackend.controller;

import lombok.RequiredArgsConstructor;
import org.hotelmanagement.hotelmanagementbackend.model.dto.ClientDto;
import org.hotelmanagement.hotelmanagementbackend.model.response.ApiResponse;
import org.hotelmanagement.hotelmanagementbackend.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/v1/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ClientDto clientDto){
        clientService.createClient(clientDto);
    }

    @GetMapping
    public ApiResponse getAll(){
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ApiResponse getById(@PathVariable Long id){
        return clientService.getClientById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        clientService.deleteClientById(id);
    }

    @PatchMapping("/{id}")
    public void checkOut(@PathVariable Long id){
        clientService.checkOut(id);
    }
}