package cheboksarov.blps_lab2.service.impl;

import cheboksarov.blps_lab2.config.MyUserDetails;
import cheboksarov.blps_lab2.model.Credential;
import cheboksarov.blps_lab2.repository.CredentialRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@NoArgsConstructor
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private CredentialRepository credentialRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.error("My User Detail Service:" + username);
        Optional<Credential> user = credentialRepository.findByUserName(username);
        return user.map(MyUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("No Users with this username: "+ username));
    }
}
