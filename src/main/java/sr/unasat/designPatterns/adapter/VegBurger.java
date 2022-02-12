package sr.unasat.designPatterns.adapter;

public class VegBurger extends VegMeal{

    public VegBurger() {
        mealName = "Veg burger";
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
