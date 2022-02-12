package sr.unasat.designPatterns.adapter;

public class PBJSandwich extends VegMeal{

    public PBJSandwich() {
        mealName = "PB & J sandwich";
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
