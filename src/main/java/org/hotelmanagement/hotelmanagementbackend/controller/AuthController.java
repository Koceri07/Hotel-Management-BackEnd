package org.hotelmanagement.hotelmanagementbackend.controller;
import lombok.RequiredArgsConstructor;
import org.hotelmanagement.hotelmanagementbackend.model.request.AuthRequest;
import org.hotelmanagement.hotelmanagementbackend.model.request.RefreshTokenRequest;
import org.hotelmanagement.hotelmanagementbackend.model.response.AuthResponse;
import org.hotelmanagement.hotelmanagementbackend.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/token")
    public AuthResponse authenticate(@RequestBody AuthRequest authRequest) {
        return authService.authenticate(authRequest);
    }

    @PostMapping("/token/refresh")
    public AuthResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }
}
