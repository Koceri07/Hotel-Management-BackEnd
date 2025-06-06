package org.hotelmanagement.hotelmanagementbackend.service;
import lombok.RequiredArgsConstructor;
import org.hotelmanagement.hotelmanagementbackend.entity.UserEntity;
import org.hotelmanagement.hotelmanagementbackend.model.request.SignUpUserRequest;
import org.hotelmanagement.hotelmanagementbackend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(SignUpUserRequest signUpUserRequest) {
        var userEntity = new UserEntity();
        userEntity.setUsername(signUpUserRequest.getUsername());
        userEntity.setPassword(passwordEncoder.encode(signUpUserRequest.getPassword()));
        userEntity.setRole(Set.of("ROLE_USER"));

        userRepository.save(userEntity);
    }
}
