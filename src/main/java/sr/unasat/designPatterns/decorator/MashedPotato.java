package sr.unasat.designPatterns.decorator;

import sr.unasat.designPatterns.protoype.Meal;

public class MashedPotato extends SideDecorator{

    Meal meal;

    public MashedPotato(Meal meal) {
        this.meal = meal;
        sideName = "Mashed potato";
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
