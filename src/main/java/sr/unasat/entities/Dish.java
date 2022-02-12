package sr.unasat.entities;

public class Dish {

    private String name;
    private String ingredients;
    private Long amountSold;

    public Dish(String name, String ingredients, Long amountSold) {
        this.name = name;
        this.ingredients = ingredients;
        this.amountSold = amountSold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Long getAmountSold() {
        return amountSold;
    }

    public void setAmountSold(Long amountSold) {
        this.amountSold = amountSold;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", amountSold=" + amountSold +
                '}';
    }
}
