package sr.unasat.designPatterns.adapter;

import sr.unasat.DAO.MealsDAO;
import sr.unasat.config.JPAConfiguration;
import sr.unasat.entities.Meals;

public abstract class VegMeal implements Cloneable{

    MealsDAO mealsDAO = new MealsDAO(JPAConfiguration.getEntityManager());

    protected String mealName;

    public Meals meal(){
        return mealsDAO.findMeal(mealName);
    }

    public void displayMeal(){
        Meals meal = meal();
        System.out.println(meal.getMealName() + " (" + meal.getMainIngredients() + ") -> SRD " +
                meal.getPrice());
    };

    public abstract double price();

    public abstract long id();

    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }


}
