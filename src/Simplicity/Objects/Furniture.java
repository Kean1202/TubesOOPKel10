public abstract class Furniture extends SimplicityObject implements PurchasableObject, Storable{
    //Atributes
    private int price; 
    private int length;
    private int width;

    //Constructor
    public Furniture(String type, int price, int length, int width){
        super(type);
        this.price = price;
        this.length = length;
        this.width = width;
    }
    
    //Setter
    public void setPrice(int price){
        this.price = price;
    }

    //Getter
    public int getPrice(){
        return price;
    }

    public int getLength(){
        return length;
    }

    public int getWidth(){
        return width;
    }

    public abstract void doAction();
}