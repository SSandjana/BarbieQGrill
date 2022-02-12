package sr.unasat.DAO;

import sr.unasat.entities.Meals;
import sr.unasat.entities.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class MealsDAO {

    private final EntityManager entityManager;

    public MealsDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Meals insert(Meals meal) {
        entityManager.getTransaction().begin();
        entityManager.persist(meal);
        entityManager.getTransaction().commit();
        return meal;
    }

    public List<Meals> findAll() {
        entityManager.getTransaction().begin();
        String jpql = "select m from Meals m";
        TypedQuery<Meals> query = entityManager.createQuery(jpql, Meals.class);
        List<Meals> dish = query.getResultList();
        entityManager.getTransaction().commit();
        return dish;
    }

    public Meals findMeal(String meal) {
        entityManager.getTransaction().begin();
        String jpql = "select m from Meals m  where m.mealName like :mealname";
        TypedQuery<Meals> query = entityManager.createQuery(jpql, Meals.class);
        Meals dish = query.setParameter("mealname", meal + "%").getSingleResult();
        entityManager.getTransaction().commit();
        return dish;
    }

    public Meals findMealById(Long id) {
        entityManager.getTransaction().begin();
        String jpql = "select m from Meals m  where m.id = :id";
        TypedQuery<Meals> query = entityManager.createQuery(jpql, Meals.class);
        Meals dish = query.setParameter("id", id).getSingleResult();
        entityManager.getTransaction().commit();
        return dish;
    }

    public double findPrice(String meal) {
        entityManager.getTransaction().begin();
        String jpql = "select m.price from Meals m  where m.mealName like :mealname";
        TypedQuery<Double> query = entityManager.createQuery(jpql, Double.class);
        double dish = query.setParameter("mealname", meal + "%").getSingleResult();
        entityManager.getTransaction().commit();
        return dish;
    }

    public int delete(String meal) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from Meals m where m.mealName = :mealName");
        query.setParameter("mealName", meal);
        int rowsDeleted = query.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }

}
