package Simplicity.Objects;

import Simplicity.Sim;

public class TV extends Furniture{
    //Constructor
    public TV(String type, int price, int length, int width) {
        super(type, price, length, width);
    }

    //masih prototype
    public void doAction(Sim sim) {
        sim.simWatchTV();
    }
}
