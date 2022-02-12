package sr.unasat.designPatterns.cor;

import sr.unasat.DAO.CredentialsDAO;
import sr.unasat.config.JPAConfiguration;
import sr.unasat.entities.Credentials;

import java.util.List;

public class ResetPassword implements AuthenticationHandler{


    CredentialsDAO credentialsDAO = new CredentialsDAO(JPAConfiguration.getEntityManager());
    private AuthenticationHandler authenticationHandler;


    @Override
    public void setNextHandler(AuthenticationHandler nextChain) {
        this.authenticationHandler = nextChain;
    }

    @Override
    public Credentials getCredential(Credentials credentials) {
        List<Credentials> credentialsList = credentialsDAO.findAll();
        for (int index = 0; index < credentialsList.size(); index++) {
            if (credentialsList.get(index).getUsername().equalsIgnoreCase(credentials.getUsername())) {
                return credentialsList.get(index);
            }}
        return null;
    }

    @Override
    public void authenticate(Credentials credentials) {
        Credentials user = getCredential(credentials);

        if (user.getTries() > 2){
            if (user.getUsername().equalsIgnoreCase(credentials.getUsername())) {
                int updatePassword = credentialsDAO.updatePassword(credentials);
                int updateTries = credentialsDAO.resetTries(credentials);
                if (updatePassword > 0 && updateTries > 0){
                    System.out.println("Reset was successful");
                    System.out.println("Please login with new credentials");
                }
            }
        }else {
            authenticationHandler.authenticate(credentials);
        }
    }

}
