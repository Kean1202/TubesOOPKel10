package Simplicity.Objects;

import Simplicity.Sim;

public class Desk extends Furniture{
    
    // Constructor
    public Desk(String type, int price, int length, int width) {
        super(type, price, length, width);
    }
    
    public void doAction(Sim sim, Edible food) {
        sim.simEat(food);
    }
}
