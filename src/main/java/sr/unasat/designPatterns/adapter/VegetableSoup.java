package sr.unasat.designPatterns.adapter;

public class VegetableSoup extends VegMeal{

    public VegetableSoup() {
        mealName = "Vegetables soup";
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
