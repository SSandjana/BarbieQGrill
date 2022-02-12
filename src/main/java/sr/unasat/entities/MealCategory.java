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
public class MealCategory {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column
    private String category;

    @OneToMany(mappedBy = "category")
    private Set<Meals> meals;

    @ManyToMany
    @JoinTable(name = "meal_types_category"
            , joinColumns = {@JoinColumn(name = "category_id")},
            inverseJoinColumns = {@JoinColumn(name = "type_id")})
    private Set<MealType> mealTypes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Meals> getMeals() {
        return meals;
    }

    public void setMeals(Set<Meals> meals) {
        this.meals = meals;
    }

    public Set<MealType> getMealTypes() {
        return mealTypes;
    }

    public void setMealTypes(Set<MealType> mealTypes) {
        this.mealTypes = mealTypes;
    }

    @Override
    public String toString() {
        return "MealCategory{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", meals=" + meals +
                ", mealTypes=" + mealTypes +
                '}';
    }
}
