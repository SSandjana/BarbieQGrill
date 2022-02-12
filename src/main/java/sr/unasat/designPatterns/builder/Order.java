package sr.unasat.designPatterns.builder;

import sr.unasat.designPatterns.protoype.Meal;

import java.util.ArrayList;
import java.util.List;

public abstract class Order {

    String orderType;
    public final List<Meal> meals = new ArrayList<>();

    public void addMeal(Meal meal){
        meals.add(meal);
    }

    public double getTotalPrice(){
        double total = 0.0;

        for (Meal meal : meals) {
            total += meal.price();
        }
        return total;
    }

    public void receipt(){
        System.out.println();
        System.out.println("Barbie-Q & Grill");
        System.out.println("Hear the sizzle ♨, savor the flavor... \uD83E\uDD69");
        System.out.println();
        System.out.println("Your " + orderType + " receipt");
        for (Meal meal : meals) {
            meal.displayMeal();
        }
        System.out.println("----------------------------------------------");
        System.out.println("Your total is SRD " + getTotalPrice()) ;
    }

}
