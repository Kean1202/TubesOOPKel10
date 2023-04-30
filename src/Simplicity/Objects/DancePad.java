package Simplicity.Objects;

import Simplicity.Sim;

public class DancePad extends Furniture{
    //Constructor
    public DancePad(String type, int price, int length, int width) {
        super(type, price, length, width);
    }

    //masih prototype
    public void doAction(Sim sim) {
        sim.dance();
    }
}
