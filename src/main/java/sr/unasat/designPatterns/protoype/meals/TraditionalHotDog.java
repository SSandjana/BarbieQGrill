package sr.unasat.designPatterns.protoype.meals;

import sr.unasat.designPatterns.protoype.Meal;

public class TraditionalHotDog extends Meal {

    public TraditionalHotDog() {
        mealName = "Traditional hot dog";
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
