package sr.unasat.designPatterns.cor;

import sr.unasat.DAO.AddressDAO;
import sr.unasat.DAO.CredentialsDAO;
import sr.unasat.DAO.UsersDAO;
import sr.unasat.config.JPAConfiguration;
import sr.unasat.entities.Address;
import sr.unasat.entities.Credentials;
import sr.unasat.entities.Users;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Registration {

    UsersDAO usersDAO = new UsersDAO(JPAConfiguration.getEntityManager());
    CredentialsDAO credentialsDAO = new CredentialsDAO(JPAConfiguration.getEntityManager());
    AddressDAO addressDAO = new AddressDAO(JPAConfiguration.getEntityManager());

    Set<Address> addresses = new HashSet<>();

    public void registrar(LocalDate birthDate, String firstName, String lastName, Address address,
                          Credentials credentials){
        addresses.add(address);
        Users someone = Users.builder().dateOfBirth(birthDate)
                .firstname(firstName).lastname(lastName).credentials(credentials)
                .address(addresses).build();

            addressDAO.insert(address);
            credentialsDAO.insert(credentials);
            usersDAO.insert(someone);
    }

    public void logOut(Credentials credentials){
        System.out.println("Log out successful");
        credentialsDAO.logOut(credentials);
    }

}
