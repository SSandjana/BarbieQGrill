package sr.unasat.designPatterns.adapter;

import sr.unasat.designPatterns.protoype.Meal;

public class VegPizza extends VegMeal {

    public VegPizza() {
        mealName = "Veg pizza";
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
