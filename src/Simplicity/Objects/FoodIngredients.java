public class FoodIngredients extends SimplicityObject implements Edible, Storable, PurchasableObject {
    private int price;
    private int repletition;

    public FoodIngredients(String type, int price, int repletition){
        super(type);
        this.price = price;
        this.repletition = repletition;
    }

    //Setter
    public void setPrice(int price){
        this.price = price;
    }

    public void setRepletition(int repletition){
        this.repletition = repletition;
    }

    //Getter
    public int getPrice(){
        return price;
    }

    public int getRepletion(){
        return repletition;
    }
}
