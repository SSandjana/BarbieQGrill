package sr.unasat.DAO;

import sr.unasat.entities.Credentials;
import sr.unasat.entities.Meals;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CredentialsDAO {

    private EntityManager entityManager;

    public CredentialsDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Credentials insert(Credentials credentials) {
        entityManager.getTransaction().begin();
        entityManager.persist(credentials);
        entityManager.getTransaction().commit();
        return credentials;
    }

    public Credentials findCredential(String username) {
        entityManager.getTransaction().begin();
        String jpql = "select c from Credentials c  where c.username = :username";
        TypedQuery<Credentials> query = entityManager.createQuery(jpql, Credentials.class);
        Credentials result = query.setParameter("username", username).getSingleResult();
        entityManager.getTransaction().commit();
        return result;
    }

    public List<Credentials> findAll() {
        entityManager.getTransaction().begin();
        String jpql = "select c from Credentials c";
        TypedQuery<Credentials> query = entityManager.createQuery(jpql, Credentials.class);
        List<Credentials> companyList = query.getResultList();
        entityManager.getTransaction().commit();
        return companyList;
    }

    public int updateCredentials(Credentials credentials) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Credentials c SET c.tries = :tries where c.username = :username");
        query.setParameter("tries", credentials.getTries()+1);
        query.setParameter("username", credentials.getUsername());
        int rowsUpdated = query.executeUpdate();
        entityManager.getTransaction().commit();
        return rowsUpdated;
    }

    public int updatePassword(Credentials credentials) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Credentials c SET c.password = :password where c.username = :username");
        query.setParameter("password", credentials.getPassword());
        query.setParameter("username", credentials.getUsername());
        int rowsUpdated = query.executeUpdate();
        entityManager.getTransaction().commit();
        return rowsUpdated;
    }

    public int resetTries(Credentials credentials) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Credentials c SET c.tries = 0 where c.username = :username");
        query.setParameter("username", credentials.getUsername());
        int rowsUpdated = query.executeUpdate();
        entityManager.getTransaction().commit();
        return rowsUpdated;
    }

    public int logOut(Credentials credentials) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Credentials c SET c.tries = 0 where c.username = :username");
        query.setParameter("username", credentials.getUsername());
        int rowsUpdated = query.executeUpdate();
        entityManager.getTransaction().commit();
        return rowsUpdated;
    }

}
