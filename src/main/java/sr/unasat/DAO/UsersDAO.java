package sr.unasat.DAO;

import sr.unasat.entities.Meals;
import sr.unasat.entities.Users;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UsersDAO {

    private EntityManager entityManager;

    public UsersDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Users insert(Users user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        return user;
    }

    public Users findUser(String firstName, String lastName) {
        entityManager.getTransaction().begin();
        String jpql = "select u from Users u  where u.firstname = :name and u.lastname = :lname";
        TypedQuery<Users> query = entityManager.createQuery(jpql, Users.class);
        Users users = query.setParameter("name", firstName)
                .setParameter("lname", lastName).getSingleResult();
        entityManager.getTransaction().commit();
        return users;
    }

}
