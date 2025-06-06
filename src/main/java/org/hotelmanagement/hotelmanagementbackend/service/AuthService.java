package org.hotelmanagement.hotelmanagementbackend.service;


import lombok.RequiredArgsConstructor;
import org.hotelmanagement.hotelmanagementbackend.model.request.AuthRequest;
import org.hotelmanagement.hotelmanagementbackend.model.request.RefreshTokenRequest;
import org.hotelmanagement.hotelmanagementbackend.model.response.AuthResponse;
import org.hotelmanagement.hotelmanagementbackend.repository.UserRepository;
import org.hotelmanagement.hotelmanagementbackend.util.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public AuthResponse authenticate(AuthRequest authRequest) {
        var userEntity = userRepository.findByUsername(authRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        var token = jwtUtil.generateAccessToken(authRequest.getUsername(), userEntity.getRole());
        var refreshToken = jwtUtil.generateRefreshToken(authRequest.getUsername());
        return new AuthResponse(token, refreshToken);
    }

    public AuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        if (jwtUtil.isTokenExpired(refreshTokenRequest.getRefreshToken())) {
            throw new RuntimeException("Refresh token is expired");
        }
        var username = jwtUtil.extractUsername(refreshTokenRequest.getRefreshToken());
        var token = jwtUtil.generateAccessToken(username, Set.of("ROLE_USER"));
        var refreshToken = jwtUtil.generateRefreshToken(username);
        return new AuthResponse(token, refreshToken);
    }
}
