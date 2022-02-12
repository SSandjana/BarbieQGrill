package sr.unasat.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Meals {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column
    private String mealName;
    @Column
    private String mainIngredients;
    @Column
    private double price;

    @ManyToOne
    @JoinColumn(name = "meal_category_id", nullable = false)
    private MealCategory category;

    @OneToMany(mappedBy = "meal")
    private Set<Sales> sales;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMainIngredients() {
        return mainIngredients;
    }

    public void setMainIngredients(String mainIngredients) {
        this.mainIngredients = mainIngredients;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MealCategory getCategory() {
        return category;
    }

    public void setCategory(MealCategory category) {
        this.category = category;
    }

    public Set<Sales> getSales() {
        return sales;
    }

    public void setSales(Set<Sales> sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Meals{" +
                "id=" + id +
                ", mealName='" + mealName + '\'' +
                ", mainIngredients='" + mainIngredients + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", sales=" + sales +
                '}';
    }
}
