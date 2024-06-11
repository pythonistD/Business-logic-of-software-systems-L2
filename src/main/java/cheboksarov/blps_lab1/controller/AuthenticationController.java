package cheboksarov.blps_lab1.controller;

import cheboksarov.blps_lab1.model.Credential;
import cheboksarov.blps_lab1.service.CredentialService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("api/v1/authenticate")
@AllArgsConstructor
public class AuthenticationController {
    private final CredentialService credentialService;
    private final AuthenticationManager provider;
    //private final PasswordEncoder passwordEncoder;
    @PostMapping("register")
    public Credential register(@RequestBody Credential credential){
        return credentialService.registerNewUser(credential);
    }

    @PostMapping("logIn")
    public ResponseEntity<?> logIn(@RequestBody Credential credential, HttpServletRequest request, HttpServletResponse response){
        log.info("I'm Here in Login endpoint!");
        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(credential.getUserName(), credential.getPassword());
            log.info("Authentication: " + authenticationToken);
            Authentication authenticationResponse = provider.authenticate(authenticationToken);
            log.info("Credentials: " + authenticationResponse.getCredentials());
            SecurityContextHolder.getContext().setAuthentication(authenticationResponse);
            if (authenticationResponse.isAuthenticated()) {
                return new ResponseEntity<>("Successfully Authenticated!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Authentication Error!", HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            log.error("Error:" + e.getMessage());
            log.error("Cause:" + e.getCause());
            log.error("Exception:" + e);
            return new ResponseEntity<>("Authentication Error!", HttpStatus.UNAUTHORIZED);
        }
    }
}
