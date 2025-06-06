package org.hotelmanagement.hotelmanagementbackend.config.filter;
import lombok.RequiredArgsConstructor;
import org.hotelmanagement.hotelmanagementbackend.entity.UserEntity;
import org.hotelmanagement.hotelmanagementbackend.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        var encoder = new BCryptPasswordEncoder();
        return new User(
                user.getUsername(),
                encoder.matches(user.getPassword(), encoder.encode(user.getPassword())) ? user.getPassword() : "",
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole().toString()))
        );
    }
}

