package org.hotelmanagement.hotelmanagementbackend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hotelmanagement.hotelmanagementbackend.model.dto.PaymentDto;
import org.hotelmanagement.hotelmanagementbackend.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public void createPayment(PaymentDto paymentDto){

    }
}
