package sr.unasat.DAO;

import sr.unasat.entities.Meals;
import sr.unasat.entities.Sides;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class SidesDAO {

    private final EntityManager entityManager;

    public SidesDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Sides insert(Sides sides) {
        entityManager.getTransaction().begin();
        entityManager.persist(sides);
        entityManager.getTransaction().commit();
        return sides;
    }

    public Sides findSide(String side) {
        entityManager.getTransaction().begin();
        String jpql = "select s from Sides s  where s.sideName = :side";
        TypedQuery<Sides> query = entityManager.createQuery(jpql, Sides.class);
        Sides sideMeal = query.setParameter("side", side).getSingleResult();
        entityManager.getTransaction().commit();
        return sideMeal;
    }

}
