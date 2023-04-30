package Simplicity.Objects;

import Simplicity.Sim;

public class YogaMat extends Furniture{
    //Constructor
    public YogaMat(String type, int price, int length, int width) {
        super(type, price, length, width);
    }

    //masih prototype
    public void doAction(Sim sim) {
        sim.doYoga();
    }
}
