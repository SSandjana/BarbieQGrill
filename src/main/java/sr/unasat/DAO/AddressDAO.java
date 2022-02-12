package sr.unasat.DAO;

import sr.unasat.entities.Address;
import sr.unasat.entities.Credentials;

import javax.persistence.EntityManager;

public class AddressDAO {

    private EntityManager entityManager;

    public AddressDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Address insert(Address address) {
        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();
        return address;
    }

}
