package com.jordaobass.catalogo.catalogoapplication.service.interfaces;

import com.jordaobass.catalogo.catalogoapplication.dto.request.SignUpRequest;
import com.jordaobass.catalogo.catalogoapplication.dto.request.SigninRequest;
import com.jordaobass.catalogo.catalogoapplication.dto.response.JwtAuthenticationResponse;

public interface IAuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
