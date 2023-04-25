package Simplicity.Objects;

import Simplicity.Sim;
import Simplicity.invalidMultitudeNumber;

public class Bed extends Furniture {

    // Constructor
    public Bed(String type, int price, int length, int width) {
        super(type, price, length, width);
    }

    //masih prototype
    public void doAction(Sim sim, int duration) throws invalidMultitudeNumber {
        sim.sleep(duration);
    }
}