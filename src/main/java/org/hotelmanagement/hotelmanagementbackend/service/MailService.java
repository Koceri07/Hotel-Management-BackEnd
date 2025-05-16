package org.hotelmanagement.hotelmanagementbackend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hotelmanagement.hotelmanagementbackend.model.dto.MailDto;
import org.hotelmanagement.hotelmanagementbackend.repository.MailRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender javaMailSender;
    private final MailRepository mailRepository;

    public void sendMail(MailDto mailDto){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailDto.getFrom());
        simpleMailMessage.setTo(mailDto.getTo());
        simpleMailMessage.setSubject(mailDto.getSubject());
        simpleMailMessage.setText(mailDto.getText());

        mailRepository.save(mailDto);
        javaMailSender.send(simpleMailMessage);
    }

    public Optional<MailDto> getMail(Long id){
        log.info("Action.getMail.start for id {}", id);
        Optional<MailDto> mail = mailRepository.findById(id);
        log.info("Action.getMail.end for id {}",id);
        return mail;
    }

    public List<MailDto> getAllMails(){
        log.info("Action.getAllMails.start");
        List<MailDto> mails = mailRepository.findAll();
        log.info("Action.getAllMails.end");
        return mails;
    }


    public void deleteMailById(Long id){
        log.info("Action.deleteMailById.start for id {}",id);
        mailRepository.deleteById(id);
        log.info("Action.deleteMailById.end for id {}",id);
    }



}
