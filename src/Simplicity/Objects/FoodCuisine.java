package Simplicity.Objects;
import java.util.ArrayList;
import java.util.List;

public class FoodCuisine extends SimplicityObject implements Edible, Storable{
	private List<FoodIngredients> ingredients;
	private int cuisineRepletion;

	//Constructor
	public FoodCuisine(String type, int repletion) {
		super(type);
		this.cuisineRepletion = repletion;
		this.ingredients = new ArrayList<>();
	}
	//Method
	public void addIngredients(FoodIngredients ingredient){
		this.ingredients.add(ingredient);
		this.cuisineRepletion = this.cuisineRepletion + ingredient.getRepletion();

	}

    public void setRepletion(int repletion){
        this.cuisineRepletion = repletion;
	}

    //Getter
    public int getRepletion(){
        return cuisineRepletion;
    }

    public List<FoodIngredients> getIngredients(){
        return ingredients;
    }
}
