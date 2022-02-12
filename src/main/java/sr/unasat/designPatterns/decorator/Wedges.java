package sr.unasat.designPatterns.decorator;

import sr.unasat.designPatterns.protoype.Meal;

public class Wedges extends SideDecorator{

    Meal meal;

    public Wedges(Meal meal) {
        this.meal = meal;
        sideName = "Wedges";
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
