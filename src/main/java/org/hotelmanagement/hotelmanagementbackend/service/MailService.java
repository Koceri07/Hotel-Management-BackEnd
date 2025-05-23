package org.hotelmanagement.hotelmanagementbackend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hotelmanagement.hotelmanagementbackend.exception.NotFoundException;
import org.hotelmanagement.hotelmanagementbackend.mapper.MailMapper;
import org.hotelmanagement.hotelmanagementbackend.model.dto.MailDto;
import org.hotelmanagement.hotelmanagementbackend.repository.MailRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender javaMailSender;
    private final MailRepository mailRepository;

    public void sendMail(MailDto mailDto){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mailDto.getMailFrom());
        simpleMailMessage.setTo(mailDto.getMailTo());
        simpleMailMessage.setSubject(mailDto.getSubject());
        simpleMailMessage.setText(mailDto.getText());

        var mailEntity = MailMapper.INSTANCE.toEntity(mailDto);

        mailRepository.save(mailEntity);
        javaMailSender.send(simpleMailMessage);
    }

    public MailDto getMail(Long id){
        log.info("Action.getMail.start for id {}", id);
        var mail = mailRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Id Not Found"));
        var mailDto = MailMapper.INSTANCE.toDto(mail);

        log.info("Action.getMail.end for id {}",id);
        return mailDto;
    }

    public List<MailDto> getAllMails(){
        log.info("Action.getAllMails.start");
        List<MailDto> mails = mailRepository.findAll()
                        .stream().map(MailMapper.INSTANCE::toDto)
                        .toList();
        log.info("Action.getAllMails.end");
        return mails;
    }


    public void deleteMailById(Long id){
        log.info("Action.deleteMailById.start for id {}",id);
        mailRepository.deleteById(id);
        log.info("Action.deleteMailById.end for id {}",id);
    }



}
