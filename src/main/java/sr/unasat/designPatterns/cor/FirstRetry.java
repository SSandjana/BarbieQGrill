package sr.unasat.designPatterns.cor;

import sr.unasat.DAO.CredentialsDAO;
import sr.unasat.DAO.MealsDAO;
import sr.unasat.config.JPAConfiguration;
import sr.unasat.entities.Credentials;
import sr.unasat.entities.MealType;
import sr.unasat.entities.Meals;

import java.util.List;

public class FirstRetry implements AuthenticationHandler{

    MealsDAO mealsDAO = new MealsDAO(JPAConfiguration.getEntityManager());
    CredentialsDAO credentialsDAO = new CredentialsDAO(JPAConfiguration.getEntityManager());
    private AuthenticationHandler authenticationHandler;


    @Override
    public void setNextHandler(AuthenticationHandler nextChain) {
        this.authenticationHandler = nextChain;
    }

    @Override
    public Credentials getCredential(Credentials credentials) {
        List<Credentials> credentialsList = credentialsDAO.findAll();
        for (int index = 0; index < credentialsList.size(); index++) {
            if (credentialsList.get(index).getUsername().equalsIgnoreCase(credentials.getUsername())) {
                return credentialsList.get(index);
            }}
        return null;
    }

    @Override
    public void authenticate(Credentials credentials) {
        Credentials user = getCredential(credentials);

        if (user.getTries() == 1){
            if (user.getUsername().equalsIgnoreCase(credentials.getUsername()) &&
                    user.getPassword().equalsIgnoreCase(credentials.getPassword())) {
                System.out.println("Login successful");
                credentialsDAO.updateCredentials(user);
                displayMenu();
            }else {
                credentialsDAO.updateCredentials(user);
                System.out.println("Invalid credentials");
            }
        }else {
            authenticationHandler.authenticate(credentials);
        }
    }

    public void displayMenu(){
        List<Meals> mealsList = mealsDAO.findAll();

        System.out.println("-------------------Menu----------------------");
        for (int index = 0; index < mealsList.size(); index++){
            System.out.println(mealsList.get(index).getMealName() + " (" +
                    mealsList.get(index).getMainIngredients() + ") -> SRD " +
                    mealsList.get(index).getPrice());
        }
    }

}
