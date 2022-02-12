package sr.unasat.designPatterns.decorator;

import sr.unasat.designPatterns.protoype.Meal;
import sr.unasat.entities.Meals;

public class Fries extends SideDecorator {

    Meal meal;

    public Fries(Meal meal) {
        this.meal = meal;
        sideName = "Fries";
    }


    @Override
    public void displayMeal() {
        meal.displayMeal();
        System.out.println("with side " + sideDish().getSideName() + " -> SRD " + sideDish().getPrice());
    }

    @Override
    public double price() {
        return meal.price() + sideDish().getPrice();
    }

    @Override
    public long id() {
        return 0;
    }
}
