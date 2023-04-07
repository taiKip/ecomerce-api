package com.example.api.init;

import com.example.api.entity.RegisterRequest;
import com.example.api.entity.Role;
import com.example.api.entity.User;
import com.example.api.repository.UserRepository;
import com.example.api.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationStartRunner implements CommandLineRunner {
    private  final AuthenticationService authenticationService;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        User user = User.builder()
                .firstname("Victor")
                .lastname("Tarus")
                .email("test@gmail.com")
                .password(passwordEncoder.encode("test123"))
                .role(Role.ADMIN)
                .build();
        authenticationService.register(user);
    }
}
