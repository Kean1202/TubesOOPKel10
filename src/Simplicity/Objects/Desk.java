package Simplicity.Objects;

import Simplicity.Sim;

public class Desk extends Furniture{
    
    // Constructor
    public Desk(String type, int price, int length, int width) {
        super(type, price, length, width);
    }
    
    //masih prototype
    public void doAction(Sim sim) {
        //sim.sleep();
    }
}
