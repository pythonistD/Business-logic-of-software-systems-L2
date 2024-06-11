package cheboksarov.blps_lab2.service;

import cheboksarov.blps_lab2.model.Credential;

public interface CredentialService {
    Credential registerNewUser(Credential credential);

    Credential findByUserName(String username) throws Exception;
}
