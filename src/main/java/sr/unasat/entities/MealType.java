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
public class MealType {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column
    private String mealType;

    @ManyToMany(mappedBy = "mealTypes")
    private Set<MealCategory> categories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public Set<MealCategory> getCategories() {
        return categories;
    }

    public void setCategories(Set<MealCategory> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "MealType{" +
                "id=" + id +
                ", mealType='" + mealType + '\'' +
                ", categories=" + categories +
                '}';
    }
}
