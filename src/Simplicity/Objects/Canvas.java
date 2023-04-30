package Simplicity.Objects;

import Simplicity.Sim;

public class Canvas extends Furniture{
    //Constructor
    public Canvas(String type, int price, int length, int width) {
        super(type, price, length, width);
    }

    //masih prototype
    public void doAction(Sim sim) {
        sim.paint();
    }
}
