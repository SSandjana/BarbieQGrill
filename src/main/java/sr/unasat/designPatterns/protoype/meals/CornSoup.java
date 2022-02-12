package sr.unasat.designPatterns.protoype.meals;

import sr.unasat.designPatterns.protoype.Meal;
import sr.unasat.entities.Meals;

public class CornSoup extends Meal {

    public CornSoup() {
        mealName = "Corn soup";
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
