package org.hotelmanagement.hotelmanagementbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ImportAutoConfiguration(exclude = SecurityAutoConfiguration.class)
public class HotelManagementBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelManagementBackEndApplication.class, args);
    }

}
