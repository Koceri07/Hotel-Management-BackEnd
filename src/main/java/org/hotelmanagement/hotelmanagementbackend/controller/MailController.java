package org.hotelmanagement.hotelmanagementbackend.controller;

import lombok.RequiredArgsConstructor;
import org.hotelmanagement.hotelmanagementbackend.model.dto.MailDto;
import org.hotelmanagement.hotelmanagementbackend.service.MailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/mail-sender")
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;

    @PostMapping
    public void sendMail(@RequestBody MailDto mailDto){
        mailService.sendMail(mailDto);
    }

    @GetMapping("/{id}")
    public Optional<MailDto> getById(@PathVariable Long id){
        return mailService.getMail(id);
    }

    @GetMapping
    public List<MailDto> getAll(){
        return mailService.getAllMails();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        mailService.deleteMailById(id);
    }
}
