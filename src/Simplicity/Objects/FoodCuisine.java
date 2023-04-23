package Simplicity.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FoodCuisine extends FoodIngredients{
	private List<String> ingredients;
	private int cuisineRepletion;

	//Constructor
	public FoodCuisine(int repletion){
		this.cuisineRepletion = repletion;
		this.ingredients = new ArrayList<>();
	}
	//Method
	@Override
	public void addIngredients(String ingredient){
		this.ingredients.add(ingredient);
		this.cuisineRepletion += ingredient.getRepletion();

	}

    public void setRepletition(int repletition){
        this.cuisineRepletition = repletition;
	}

    //Getter
    public int getRepletition(){
        return cuisineRepletion;
    }

    public List<FoodIngredients> getIngredients(){
        return ingredients;
    }
}
