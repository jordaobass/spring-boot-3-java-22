package com.jordaobass.catalogo.catalogoapplication.service;

import com.jordaobass.catalogo.catalogoapplication.dto.request.SignUpRequest;
import com.jordaobass.catalogo.catalogoapplication.dto.request.SigninRequest;
import com.jordaobass.catalogo.catalogoapplication.dto.response.JwtAuthenticationResponse;
import com.jordaobass.catalogo.catalogoapplication.entity.enuns.Role;
import com.jordaobass.catalogo.catalogoapplication.entity.User;
import com.jordaobass.catalogo.catalogoapplication.repository.UserRepository;
import com.jordaobass.catalogo.catalogoapplication.service.interfaces.IAuthenticationService;
import com.jordaobass.catalogo.catalogoapplication.service.interfaces.IJwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements IAuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final IJwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER).build();

        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
