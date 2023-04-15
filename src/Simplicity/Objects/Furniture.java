public abstract class Furniture implements PurchasableObject{
    //Atributes
    private String name;
    private int price;
    private int length;
    private int width;

    //Constructor
    public Furniture(String name, int price, int length, int width){
        this.name = name;
        this.price = price;
        this.length = length;
        this.width = width;
    }

    //Getter
    public String getName(){
        return name;
    }
    
    public int getPrice(){
        return price;
    }

    public int getLength(){
        return length;
    }

    public int getWidth(){
        return width;
    }
}