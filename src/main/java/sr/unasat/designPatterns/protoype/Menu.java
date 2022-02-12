package sr.unasat.designPatterns.protoype;

import sr.unasat.designPatterns.protoype.meals.*;

import java.util.Hashtable;

public class Menu {

    private static final Hashtable<String, Meal> menuList = new Hashtable<>();

    public static Meal getMeal(String mealName) {
        Meal meal = menuList.get(mealName);
        return (Meal) meal.clone();
    }

    public static void menuItems() {
        CheeseBurger cheeseBurger = new CheeseBurger();
        menuList.put(cheeseBurger.mealName, cheeseBurger);

        ChickenPizza chickenPizza = new ChickenPizza();
        menuList.put(chickenPizza.mealName, chickenPizza);

        CornSoup cornSoup = new CornSoup();
        menuList.put(cornSoup.mealName, cornSoup);

        EggAndBaconSandwich eggAndBaconSandwich = new EggAndBaconSandwich();
        menuList.put(eggAndBaconSandwich.mealName, eggAndBaconSandwich);

        EggAndMisoSoup eggAndMisoSoup = new EggAndMisoSoup();
        menuList.put(eggAndMisoSoup.mealName, eggAndMisoSoup);

        GreekPizza greekPizza = new GreekPizza();
        menuList.put(greekPizza.mealName, greekPizza);

        GrilledChickenBurger grilledChickenBurger = new GrilledChickenBurger();
        menuList.put(grilledChickenBurger.mealName, grilledChickenBurger);

        GrilledSalmon grilledSalmon = new GrilledSalmon();
        menuList.put(grilledSalmon.mealName, grilledSalmon);

        Hamburger hamburger = new Hamburger();
        menuList.put(hamburger.mealName, hamburger);

        HangerSteak hangerSteak = new HangerSteak();
        menuList.put(hangerSteak.mealName, hangerSteak);

        LobsterSandwich lobsterSandwich = new LobsterSandwich();
        menuList.put(lobsterSandwich.mealName, lobsterSandwich);

        PineappleAndPork pineappleAndPork = new PineappleAndPork();
        menuList.put(pineappleAndPork.mealName, pineappleAndPork);

        PorkSkewers porkSkewers = new PorkSkewers();
        menuList.put(porkSkewers.mealName, porkSkewers);

        RibEyeSteak ribEyeSteak = new RibEyeSteak();
        menuList.put(ribEyeSteak.mealName, ribEyeSteak);

        Sausage sausage = new Sausage();
        menuList.put(sausage.mealName, sausage);

        StripSteak stripSteak = new StripSteak();
        menuList.put(stripSteak.mealName, stripSteak);

        TraditionalHotDog traditionalHotDog = new TraditionalHotDog();
        menuList.put(traditionalHotDog.mealName, traditionalHotDog);
    }

}
