package Simplicity.Objects;

import Simplicity.Sim;

public class Toilet extends Furniture{
    //Constructor
    public Toilet(String type, int price, int length, int width) {
        super(type, price, length, width);
    }

    //masih prototype
    public void doAction(Sim sim) {
        sim.useBathroom();
    }
}
