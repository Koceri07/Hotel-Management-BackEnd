package org.hotelmanagement.hotelmanagementbackend.controller;

import lombok.RequiredArgsConstructor;
import org.hotelmanagement.hotelmanagementbackend.dto.ClientDto;
import org.hotelmanagement.hotelmanagementbackend.entity.ClientEntity;
import org.hotelmanagement.hotelmanagementbackend.repository.ClientRepository;
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
    public List<ClientDto> getAll(){
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ClientDto getById(@PathVariable Long id){
        return clientService.getClientById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        clientService.deleteClientById(id);
    }


}
