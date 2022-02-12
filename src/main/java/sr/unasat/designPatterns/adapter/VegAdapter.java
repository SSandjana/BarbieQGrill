package sr.unasat.designPatterns.adapter;

import sr.unasat.designPatterns.protoype.Meal;
import sr.unasat.designPatterns.protoype.meals.*;

public class VegAdapter extends Meal {

    VegMeal vegMeal;
    Object meal;

    public VegAdapter(Object meal) {
        this.meal = meal;
        if (meal.getClass().isInstance(new ChickenPizza()) || meal.getClass().isInstance(new GreekPizza())){
            this.vegMeal = new VegPizza();
        }else if (meal.getClass().isInstance(new CornSoup()) || meal.getClass()
                .isInstance(new EggAndMisoSoup())){
            this.vegMeal = new VegetableSoup();
        }else if (meal.getClass().isInstance(new CheeseBurger()) || meal.getClass()
                .isInstance(new Hamburger())){
            this.vegMeal = new VegBurger();
        }else if (meal.getClass().isInstance(new EggAndBaconSandwich()) || meal.getClass()
                .isInstance(new LobsterSandwich())){
            this.vegMeal = new VegBurger();
        }else {
            System.out.println("There is no veg substitute available for this dish");
        }
    }

    @Override
    public void displayMeal(){
        vegMeal.displayMeal();
    }

    @Override
    public double price() {
        return vegMeal.price();
    }

    @Override
    public long id() {
        return vegMeal.id();
    }
}
