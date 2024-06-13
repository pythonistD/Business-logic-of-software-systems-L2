package cheboksarov.blps_lab2.service.impl;

import cheboksarov.blps_lab2.controller.AuthenticationResponse;
import cheboksarov.blps_lab2.dto.AuthenticationRequestDto;
import cheboksarov.blps_lab2.dto.RegisterRequestDto;
import cheboksarov.blps_lab2.model.Credential;
import cheboksarov.blps_lab2.model.SiteUser;
import cheboksarov.blps_lab2.repository.CredentialRepository;
import cheboksarov.blps_lab2.service.AuthenticationService;
import cheboksarov.blps_lab2.service.JwtService;
import cheboksarov.blps_lab2.service.SiteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImplement implements AuthenticationService {
    private final CredentialRepository credentialRepository;
    private final SiteUserService siteUserService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public AuthenticationResponse logIn(AuthenticationRequestDto requestDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requestDto.getUsername(),
                        requestDto.getPassword()
                )
        );
        var user = credentialRepository.findByUserName(requestDto.getUsername()).orElseThrow();
        var token = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(token).build();
    }

    @Override
    public AuthenticationResponse register(RegisterRequestDto requestDto) {
        var credential = Credential.builder()
                .userName(requestDto.getUsername())
                .password(passwordEncoder.encode(requestDto.getPassword())).build();
        credentialRepository.save(credential);
        var siteUser = SiteUser.builder()
                .firstName(requestDto.getFirstName())
                .lastName(requestDto.getLastName())
                .credential(credential).build();
        siteUserService.createNewUser(siteUser);
        var token = jwtService.generateToken(credential);
        return AuthenticationResponse.builder()
                .token(token).build();
    }
}
