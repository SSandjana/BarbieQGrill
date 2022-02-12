package sr.unasat.designPatterns.protoype.meals;

import sr.unasat.designPatterns.protoype.Meal;

public class StripSteak extends Meal {

    public StripSteak() {
        mealName = "Strip steak";
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
