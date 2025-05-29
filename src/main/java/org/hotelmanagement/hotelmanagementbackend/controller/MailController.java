package org.hotelmanagement.hotelmanagementbackend.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.hotelmanagement.hotelmanagementbackend.model.dto.MailDto;
import org.hotelmanagement.hotelmanagementbackend.model.response.ApiResponse;
import org.hotelmanagement.hotelmanagementbackend.service.MailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/mail-sender")
@RequiredArgsConstructor
@OpenAPIDefinition(tags = {
        @Tag(name = "Mail", description = "Mails operations")
})
public class MailController {
    private final MailService mailService;

    @PostMapping
    public void sendMail(@RequestBody MailDto mailDto){
        mailService.sendMail(mailDto);
    }

    @GetMapping("/{id}")
    public ApiResponse getById(@PathVariable Long id){
        return mailService.getMail(id);
    }

    @GetMapping
    public ApiResponse getAll(){
        return mailService.getAllMails();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        mailService.deleteMailById(id);
    }
}
