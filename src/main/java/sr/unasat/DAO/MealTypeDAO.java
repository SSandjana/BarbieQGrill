package sr.unasat.DAO;

import sr.unasat.entities.MealType;
import sr.unasat.entities.Meals;

import javax.persistence.EntityManager;

public class MealTypeDAO {

    private final EntityManager entityManager;

    public MealTypeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public MealType insert(MealType mealType) {
        entityManager.getTransaction().begin();
        entityManager.persist(mealType);
        entityManager.getTransaction().commit();
        return mealType;
    }

}
