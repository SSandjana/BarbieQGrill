package sr.unasat.designPatterns.decorator;

import sr.unasat.designPatterns.protoype.Meal;

public class Salad extends SideDecorator{

    Meal meal;

    public Salad(Meal meal) {
        this.meal = meal;
        sideName = "Salad";
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
