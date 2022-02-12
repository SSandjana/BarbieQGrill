package sr.unasat.designPatterns.protoype.meals;

import sr.unasat.designPatterns.protoype.Meal;

public class ChickenPizza extends Meal {

    public ChickenPizza() {
        mealName = "Chicken pizza";
    }

    @Override
    public double price() {
        return meal().getPrice();
    }

    @Override
    public long id() {
        return meal().getId();
    }

}
