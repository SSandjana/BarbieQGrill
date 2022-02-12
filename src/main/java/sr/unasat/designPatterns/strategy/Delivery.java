package sr.unasat.designPatterns.strategy;

import sr.unasat.DAO.MealsDAO;
import sr.unasat.DAO.SalesDAO;
import sr.unasat.DAO.ServiceDAO;
import sr.unasat.DAO.UsersDAO;
import sr.unasat.config.JPAConfiguration;
import sr.unasat.designPatterns.protoype.Meal;
import sr.unasat.entities.Meals;
import sr.unasat.entities.Sales;
import sr.unasat.entities.Service;
import sr.unasat.entities.Users;

import java.time.LocalDate;
import java.util.List;

public class Delivery implements Strategy{

    MealsDAO mealsDAO = new MealsDAO(JPAConfiguration.getEntityManager());
    SalesDAO salesDAO = new SalesDAO(JPAConfiguration.getEntityManager());
    ServiceDAO serviceDAO = new ServiceDAO(JPAConfiguration.getEntityManager());
    UsersDAO usersDAO = new UsersDAO(JPAConfiguration.getEntityManager());

    @Override
    public void insertSales(List<Meal> meals, Users users, boolean doPayment) {
        Sales sales;

        for (int index = 0; index < meals.size(); index++){
            Meals dish = mealsDAO.findMealById(meals.get(index).id());
            Service dineIn = serviceDAO.findService("Delivery");
            Users user = usersDAO.findUser(users.getFirstname(), users.getLastname());
            sales = Sales.builder().date(LocalDate.now()).payed(true).meal(dish).service(dineIn)
                    .user(user).build();
            salesDAO.insert(sales);
        }
    }

}
