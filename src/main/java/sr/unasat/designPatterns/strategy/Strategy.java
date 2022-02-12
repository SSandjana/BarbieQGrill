package sr.unasat.designPatterns.strategy;

import sr.unasat.designPatterns.protoype.Meal;
import sr.unasat.entities.Users;

import java.util.List;

public interface Strategy {

    public void insertSales(List<Meal> meals, Users users, boolean doPayment);

}
