package sr.unasat.designPatterns.protoype.meals;

import sr.unasat.designPatterns.protoype.Meal;

public class PorkSkewers extends Meal {

    public PorkSkewers() {
        mealName = "Pork Skewers";
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
