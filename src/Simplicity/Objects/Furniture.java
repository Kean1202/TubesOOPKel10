package Simplicity.Objects;

import Simplicity.Point;

public abstract class Furniture extends SimplicityObject implements PurchasableObject, Storable{
    //Atributes
    private int price; 
    private int length;
    private int width;
    private Point furnitureLocation;

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

    public void setLength(int length){
        this.length = length;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setLocation(Point furnitureLocation) {
        this.furnitureLocation = furnitureLocation;
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

    public Point getFurnitureLocation() {
        return furnitureLocation;
    }

}
