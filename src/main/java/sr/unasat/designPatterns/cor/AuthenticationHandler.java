package sr.unasat.designPatterns.cor;

import sr.unasat.entities.Address;
import sr.unasat.entities.Credentials;

import java.time.LocalDate;

public interface AuthenticationHandler {

    void setNextHandler(AuthenticationHandler nextChain);
    Credentials getCredential(Credentials credentials);
    void authenticate(Credentials credentials);

}
