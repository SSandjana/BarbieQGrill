package sr.unasat.app;

import sr.unasat.DAO.*;
import sr.unasat.config.JPAConfiguration;
import sr.unasat.designPatterns.adapter.VegAdapter;
import sr.unasat.designPatterns.adapter.VegPizza;
import sr.unasat.designPatterns.builder.Breakfast;
import sr.unasat.designPatterns.builder.Lunch;
import sr.unasat.designPatterns.builder.Order;
import sr.unasat.designPatterns.cor.AuthenticationChain;
import sr.unasat.designPatterns.cor.Registration;
import sr.unasat.designPatterns.decorator.Fries;
import sr.unasat.designPatterns.decorator.Salad;
import sr.unasat.designPatterns.protoype.Meal;
import sr.unasat.designPatterns.protoype.Menu;
import sr.unasat.designPatterns.protoype.meals.CheeseBurger;
import sr.unasat.designPatterns.protoype.meals.ChickenPizza;
import sr.unasat.designPatterns.protoype.meals.Hamburger;
import sr.unasat.designPatterns.protoype.meals.PorkSkewers;
import sr.unasat.designPatterns.strategy.Delivery;
import sr.unasat.designPatterns.strategy.DineIn;
import sr.unasat.designPatterns.strategy.PlaceOrder;
import sr.unasat.entities.*;
import sr.unasat.rapportages.Rapportages;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        MealsDAO mealsDAO = new MealsDAO(JPAConfiguration.getEntityManager());
        MealCategoryDAO mealCategoryDAO = new MealCategoryDAO(JPAConfiguration.getEntityManager());
        MealTypeDAO mealTypeDAO = new MealTypeDAO(JPAConfiguration.getEntityManager());
        SidesDAO sidesDAO = new SidesDAO(JPAConfiguration.getEntityManager());
        UsersDAO usersDAO = new UsersDAO(JPAConfiguration.getEntityManager());
        CredentialsDAO credentialsDAO = new CredentialsDAO(JPAConfiguration.getEntityManager());
        AddressDAO addressDAO = new AddressDAO(JPAConfiguration.getEntityManager());
        SalesDAO salesDAO = new SalesDAO(JPAConfiguration.getEntityManager());
        ServiceDAO serviceDAO = new ServiceDAO(JPAConfiguration.getEntityManager());

        Registration registration = new Registration();
        AuthenticationChain authentication = new AuthenticationChain();
        Rapportages rapportages = new Rapportages();

        JPAConfiguration.getEntityManager();

        System.out.println("\n \n \n \n \n \n \n");
        System.out.println("Barbie-Q & Grill");
        System.out.println("Hear the sizzle ♨, savor the flavor... \uD83E\uDD69");
        System.out.println();

//        //Insert meal types ---------------------------------------------------------------
//        MealType breakfast = MealType.builder().mealType("Breakfast").build();
//        MealType lunch = MealType.builder().mealType("Lunch").build();
//        MealType dinner = MealType.builder().mealType("Dinner").build();
//
//        mealTypeDAO.insert(breakfast);
//        mealTypeDAO.insert(lunch);
//        mealTypeDAO.insert(dinner);
//
//        //Insert meal categories ----------------------------------------
//        Set<MealType> mealTypes = new HashSet<>();
//        mealTypes.add(breakfast);
//        Set<MealType> mealTypes1 = new HashSet<>();
//        mealTypes1.add(breakfast);
//        mealTypes1.add(lunch);
//        mealTypes1.add(dinner);
//        Set<MealType> mealTypes2 = new HashSet<>();
//        mealTypes2.add(lunch);
//        mealTypes2.add(dinner);
//        Set<MealType> mealTypes3 = new HashSet<>();
//        mealTypes3.add(lunch);
//
//        MealCategory soup = MealCategory.builder().category("Soup").mealTypes(mealTypes).build();
//        MealCategory hotDogs = MealCategory.builder().category("Hot dog").mealTypes(mealTypes).build();
//        MealCategory sandwich = MealCategory.builder().category("Sandwich").mealTypes(mealTypes).build();
//        MealCategory burger = MealCategory.builder().category("Burger").mealTypes(mealTypes1).build();
//
//        MealCategory pizza = MealCategory.builder().category("Pizza").mealTypes(mealTypes2).build();
//        MealCategory steak = MealCategory.builder().category("Steak").mealTypes(mealTypes2).build();
//        MealCategory fish = MealCategory.builder().category("Fish").mealTypes(mealTypes3).build();
//        MealCategory barbecue = MealCategory.builder().category("Barbecue").mealTypes(mealTypes2).build();
//
//        MealCategory sides = MealCategory.builder().category("Sides").mealTypes(mealTypes1).build();
//
//        mealCategoryDAO.insert(soup);
//        mealCategoryDAO.insert(hotDogs);
//        mealCategoryDAO.insert(sandwich);
//        mealCategoryDAO.insert(burger);
//        mealCategoryDAO.insert(pizza);
//        mealCategoryDAO.insert(steak);
//        mealCategoryDAO.insert(fish);
//        mealCategoryDAO.insert(barbecue);
//        mealCategoryDAO.insert(sides);
//
//        Meals cornSoup = Meals.builder().mealName("Corn soup \uD83E\uDD63").mainIngredients("Corn, Chicken")
//                .category(soup).price(35.00).build();
//        mealsDAO.insert(cornSoup);
//
//        Meals eggAndMisoSoup = Meals.builder().mealName("Egg and Miso soup \uD83C\uDF72")
//                .mainIngredients("Miso, Chicken, Egg").price(37.50).category(soup).build();
//        mealsDAO.insert(eggAndMisoSoup);
//
//        Meals traditionalHotDog = Meals.builder().mealName("Traditional hot dog \uD83C\uDF2D")
//                .mainIngredients("Hot dog, bread").price(50.00).category(hotDogs).build();
//        mealsDAO.insert(traditionalHotDog);
//
//        Meals eggAndBaconSandwich = Meals.builder().mealName("Egg and bacon sandwich \uD83E\uDD6A")
//                .mainIngredients("Bacon, egg").price(25.00).category(sandwich).build();
//        mealsDAO.insert(eggAndBaconSandwich);
//
//        Meals lobsterSandwich = Meals.builder().mealName("Lobster sandwich \uD83E\uDD6A")
//                .mainIngredients("Lobster, lettuce").price(75.99).category(sandwich).build();
//        mealsDAO.insert(lobsterSandwich);
//
//        Meals cheeseBurger = Meals.builder().mealName("Cheese burger \uD83C\uDF54")
//                .mainIngredients("Cheese, tomato, pickle, burger").price(45.00).category(burger).build();
//        mealsDAO.insert(cheeseBurger);
//
//        Meals hamburger = Meals.builder().mealName("Hamburger \uD83C\uDF54")
//                .mainIngredients("Cheese, tomato, pickle, ham").price(47.50).category(burger).build();
//        mealsDAO.insert(hamburger);
//
//        Meals grilledChickenBurger = Meals.builder().mealName("Grilled chicken burger \uD83C\uDF54")
//                .mainIngredients("Cheese, tomato, pickle, grilled chicken").price(50.99).category(burger).build();
//        mealsDAO.insert(grilledChickenBurger);
//
//        Meals chickenPizza = Meals.builder().mealName("Chicken pizza \uD83C\uDF55")
//                .mainIngredients("Cheese, chicken").price(105.00).category(pizza).build();
//        mealsDAO.insert(chickenPizza);
//
//        Meals greekPizza = Meals.builder().mealName("Greek pizza \uD83C\uDF55")
//                .mainIngredients("Cheese, chicken").price(111.00).category(pizza).build();
//        mealsDAO.insert(greekPizza);
//
//        Meals stripSteak = Meals.builder().mealName("Strip steak \uD83E\uDD69")
//                .mainIngredients("Pork strip").price(150.00).category(steak).build();
//        mealsDAO.insert(stripSteak);
//
//        Meals hangerSteak = Meals.builder().mealName("Hanger steak \uD83E\uDD69")
//                .mainIngredients("Pork hanger").price(177.77).category(steak).build();
//        mealsDAO.insert(hangerSteak);
//
//        Meals ribeyeSteak = Meals.builder().mealName("Ribeye steak \uD83E\uDD69")
//                .mainIngredients("Pork Ribeye").price(180.00).category(steak).build();
//        mealsDAO.insert(ribeyeSteak);
//
//        Meals grilledSalmon = Meals.builder().mealName("Grilled salmon \uD83C\uDF63")
//                .mainIngredients("Salmon").price(117.50).category(fish).build();
//        mealsDAO.insert(grilledSalmon);
//
//        Meals sausage = Meals.builder().mealName("Sausage \uD83C\uDF56")
//                .mainIngredients("Chicken sausage").price(75.00).category(barbecue).build();
//        mealsDAO.insert(sausage);
//
//        Meals pineapplePork = Meals.builder().mealName("Pineapple and pork \uD83C\uDF56")
//                .mainIngredients("Pork, pineapple").price(145.50).category(barbecue).build();
//        mealsDAO.insert(pineapplePork);
//
//        Meals porkSkewers = Meals.builder().mealName("Pork Skewers \uD83C\uDF56")
//                .mainIngredients("Pork").price(190.00).category(barbecue).build();
//        mealsDAO.insert(porkSkewers);
//
//        Sides fries = Sides.builder().sideName("Fries").price(10.00).build();
//        sidesDAO.insert(fries);
//        Sides wedges = Sides.builder().sideName("Wedges").price(17.50).build();
//        sidesDAO.insert(wedges);
//        Sides salad = Sides.builder().sideName("Salad").price(7.75).build();
//        sidesDAO.insert(salad);
//        Sides mashedPotato = Sides.builder().sideName("Mashed potato").price(11.99).build();
//        sidesDAO.insert(mashedPotato);

//        mealsDAO.delete("Noodles");

        //Users ---------------------------------------------------------------------------
        Credentials credentials = Credentials.builder().username("username7").password("password7").build();
        Address address = Address.builder().streetName("Somewhere").streetNumber(7).build();
        Set<Address> addresses = new HashSet<>();
        addresses.add(address);
        Users someone = Users.builder().dateOfBirth(LocalDate.of(2000, 2, 14))
                .firstname("Someone").lastname("Anyone").credentials(credentials)
                .address(addresses).build();

//        Credentials credentialsAgain = Credentials.builder().username("username7").password("password7")
//                .build();
//        Address addressAgain = Address.builder().streetName("Somewhere").streetNumber(7).build();
//        Set<Address> addressesAgain = new HashSet<>();
//        addressesAgain.add(addressAgain);
//        Users someoneAgain = Users.builder().dateOfBirth(LocalDate.of(2001, 5, 17))
//                .firstname("Someone again").lastname("Anyone").credentials(credentialsAgain)
//                .address(addressesAgain).build();






//        //Registration ------------------------------------------------------------
//        registration.registrar(LocalDate.of(2001, 5, 17), "Someone again",
//                "Anyone", address, credentials);
//
//        //Chain of Responsibility -------------------------------------------------
//        authentication.firstAuthenticationHandler.authenticate(credentials);
//        registration.logOut(credentials);
//
//        //Prototype -------------------------------------------------------------
        Menu.menuItems();
//
//        Meal cheeseburger = Menu.getMeal("Cheese burger");
//        cheeseburger.displayMeal();
//
//        //Decorator with prototype ----------------------------------------------
//        cheeseburger = new Fries(cheeseburger);
//        cheeseburger.displayMeal();
//        System.out.println("Combo price SRD " + cheeseburger.price());
//
//        //Adapter ---------------------------------------------------------------
//        Meal vegCheeseBurger = new VegAdapter(new CheeseBurger());
//        vegCheeseBurger.displayMeal();
//
//        Meal vegChickenPizza = new VegAdapter(Menu.getMeal("Chicken pizza"));
//        vegChickenPizza.displayMeal();
//        System.out.println(vegChickenPizza.price());
//
//        //Builder ---------------------------------------------------------------
//        Order breakfast = new Breakfast();
//        breakfast.addMeal(cheeseburger);
//        breakfast.addMeal(vegCheeseBurger);
//        breakfast.addMeal(vegChickenPizza);
//        breakfast.receipt();
//
//        //Strategy --------------------------------------------------------------
//        Order lunch = new Lunch();
//        lunch.addMeal(Menu.getMeal("Hamburger"));
//        lunch.addMeal(new VegAdapter(Menu.getMeal("Greek pizza")));
//        lunch.receipt();
//        PlaceOrder placeOrder = new PlaceOrder(new DineIn());
//        placeOrder.confirmOrder(lunch.meals, someone, true);

        //Rapportages -------------------------------------------------------------
        //Bestsellers per service -----------
//        rapportages.bestsellerPerService("Dine in");
        //Bestseller of all service types ---
//        rapportages.bestsellerAllTypes();
        //Bestseller per week ---------------
//        rapportages.weeklySpecial(LocalDate.of(2022, 2, 7),
//                LocalDate.of(2022, 2, 11));
        //Most frequent customers -----------
//        rapportages.mostFrequentCustomers();



        System.out.println("\n \n \n \n \n \n \n");
        JPAConfiguration.shutdown();
    }
}
