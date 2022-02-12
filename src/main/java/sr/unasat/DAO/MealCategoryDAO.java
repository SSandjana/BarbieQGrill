package sr.unasat.DAO;

import sr.unasat.entities.MealCategory;
import sr.unasat.entities.Meals;

import javax.persistence.EntityManager;

public class MealCategoryDAO {

    private EntityManager entityManager;

    public MealCategoryDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public MealCategory insert(MealCategory mealCategory) {
        entityManager.getTransaction().begin();
        entityManager.persist(mealCategory);
        entityManager.getTransaction().commit();
        return mealCategory;
    }

}
