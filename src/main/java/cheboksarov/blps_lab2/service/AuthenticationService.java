package cheboksarov.blps_lab2.service;

import cheboksarov.blps_lab2.controller.AuthenticationResponse;
import cheboksarov.blps_lab2.dto.AuthenticationRequestDto;
import cheboksarov.blps_lab2.dto.RegisterRequestDto;

public interface AuthenticationService {
    AuthenticationResponse logIn(AuthenticationRequestDto requestDto);
    AuthenticationResponse register(RegisterRequestDto requestDto);
}
