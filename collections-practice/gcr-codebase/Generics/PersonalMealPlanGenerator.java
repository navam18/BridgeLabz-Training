interface MealPlan {
    String getMealType();
    int getCalories();
}
class VegetarianMeal implements MealPlan {
    public String getMealType() {
        return "Vegetarian";
    }

    public int getCalories() {
        return 1800;
    }
}

class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan";
    }

    public int getCalories() {
        return 1600;
    }
}

class KetoMeal implements MealPlan {
    public String getMealType() {
        return "Keto";
    }

    public int getCalories() {
        return 2000;
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealType() {
        return "High Protein";
    }

    public int getCalories() {
        return 2200;
    }
}
class Meal<T extends MealPlan> {

    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void showMealDetails() {
        System.out.println("Meal Type: " + mealPlan.getMealType());
        System.out.println("Calories: " + mealPlan.getCalories());
    }
}
class MealPlanGenerator {

    public static <T extends MealPlan> T generateMealPlan(T meal) {
        System.out.println("Validating meal plan: " + meal.getMealType());
        return meal;
    }
}

public class PersonalMealPlanGenerator {

    public static void main(String[] args) {
        VegetarianMeal veg = MealPlanGenerator.generateMealPlan(new VegetarianMeal());
        Meal<VegetarianMeal> vegMeal = new Meal<>(veg);
        vegMeal.showMealDetails();

        KetoMeal keto = MealPlanGenerator.generateMealPlan(new KetoMeal());
        Meal<KetoMeal> ketoMeal = new Meal<>(keto);
        ketoMeal.showMealDetails();
    }

}

