package org.hotelmanagement.hotelmanagementbackend.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpUserRequest {
    private String username;
    private String password;
}