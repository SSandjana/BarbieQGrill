package sr.unasat.rapportages;

import sr.unasat.DAO.MealsDAO;
import sr.unasat.DAO.SalesDAO;
import sr.unasat.DAO.ServiceDAO;
import sr.unasat.config.JPAConfiguration;
import sr.unasat.entities.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Rapportages {

    SalesDAO salesDAO = new SalesDAO(JPAConfiguration.getEntityManager());
    ServiceDAO serviceDAO = new ServiceDAO(JPAConfiguration.getEntityManager());
    MealsDAO mealsDAO = new MealsDAO(JPAConfiguration.getEntityManager());

    public void bestsellerPerService(String serviceType){
        List<Dish> dishes = new ArrayList<>();
        Service service = serviceDAO.findService(serviceType);
        List<Meals> mealsList = salesDAO.findByType(service);
        List<Long> totals = salesDAO.findTotalByType(service);

        for (int index = 0; index < mealsList.size(); index++){
            dishes.add(new Dish(mealsList.get(index).getMealName(), mealsList.get(index)
                    .getMainIngredients(), totals.get(index)));
        }

        Long max = Collections.max(totals);
        System.out.println("Bestsellers for " + serviceType + " are:");
        for (Dish dish : dishes) {
            if (dish.getAmountSold().equals(max)) {
                System.out.println("- " + dish.getName() + " (" + dish.getIngredients() + ")");
            }
        }

    }

    public void bestsellerAllTypes(){
        bestsellerPerService("Dine in");
        bestsellerPerService("Take out");
        bestsellerPerService("Delivery");
    }

    public void weeklySpecial(LocalDate from, LocalDate to){
        List<Meals> mealsList = salesDAO.findByDate(from, to);
        List<Long> total = salesDAO.findTotalByDate(from, to);
        List<Dish> dishes = new ArrayList<>();
        Long max = Collections.max(total);

        for (int index = 0; index < mealsList.size(); index++){
            dishes.add(new Dish(mealsList.get(index).getMealName(), mealsList.get(index)
                    .getMainIngredients(), total.get(index)));
        }

        System.out.println("Weekend special");
        System.out.println("Please come and try our");
        for (Dish dish : dishes) {
            if (dish.getAmountSold().equals(max)) {
                System.out.println(dish.getName() + " (" + dish.getIngredients() + ")");
                System.out.println("Just for SRD " + mealsDAO.findPrice(dish.getName()));
            }
        }

    }

    public void mostFrequentCustomers(){
        List<Users> users = salesDAO.findCustomers();
        List<Long> frequency = salesDAO.findFrequency();
        List<Customers> customers = new ArrayList<>();

        for (int index = 0; index < users.size(); index++) {
            customers.add(new Customers(users.get(index).getFirstname(), users.get(index).getLastname(),
                    frequency.get(index)));
        }

        System.out.println("Most frequent customers are");
        for (int index = 0; index < 2; index++){
            Long max = Collections.max(frequency);

            for (int user = 0; user < customers.size(); user++) {
                if (customers.get(user).getFrequency().equals(max)){
                    System.out.println(customers.get(user).getFirstName() +
                            " " + customers.get(user).getLastName());
                }
            }
            for (int freqIndex = 0; freqIndex < frequency.size(); freqIndex++){
                if (frequency.get(freqIndex).equals(max)){
                    frequency.remove(freqIndex);
                }
            }
        }

    }

}
