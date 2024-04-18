package com.jordaobass.catalogo.catalogoapplication.controller;

import com.jordaobass.catalogo.catalogoapplication.dto.request.SignUpRequest;
import com.jordaobass.catalogo.catalogoapplication.dto.request.SigninRequest;
import com.jordaobass.catalogo.catalogoapplication.dto.response.JwtAuthenticationResponse;
import com.jordaobass.catalogo.catalogoapplication.service.interfaces.IAuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final IAuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody @Valid SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody @Valid SigninRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}
