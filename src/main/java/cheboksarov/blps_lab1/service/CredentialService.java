package cheboksarov.blps_lab1.service;

import cheboksarov.blps_lab1.model.Credential;

public interface CredentialService {
    Credential registerNewUser(Credential credential);

    Credential findByUserName(String username) throws Exception;
}
