package sr.unasat.designPatterns.strategy;

import sr.unasat.designPatterns.protoype.Meal;
import sr.unasat.entities.Users;

import java.util.List;

public class PlaceOrder {

    Strategy strategy;

    public PlaceOrder(Strategy strategy) {
        this.strategy = strategy;
    }

    public void confirmOrder(List<Meal> meals, Users users, boolean doPayment){
        strategy.insertSales(meals, users, doPayment);
    }

}
