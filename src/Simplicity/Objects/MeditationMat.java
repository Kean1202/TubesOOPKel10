package Simplicity.Objects;

import Simplicity.Sim;

public class MeditationMat extends Furniture{
    //Constructor
    public MeditationMat(String type, int price, int length, int width) {
        super(type, price, length, width);
    }

    //masih prototype
    public void doAction(Sim sim) {
        sim.meditate();
    }
}
