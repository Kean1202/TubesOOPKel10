package Simplicity.Objects;

public class FoodIngredients extends SimplicityObject implements Edible, Storable, PurchasableObject {
    private int price;
    private int repletion;

    public FoodIngredients(String type, int price, int repletion){
        super(type);
        this.price = price;
        this.repletion = repletion;
    }

    //Setter
    public void setPrice(int price){
        this.price = price;
    }

    public void setRepletion(int repletion){
        this.repletion = repletion;
    }

    //Getter
    public int getPrice(){
        return price;
    }

    public int getRepletion(){
        return repletion;
    }
}
