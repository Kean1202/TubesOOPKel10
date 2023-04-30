package Simplicity.Objects;

import Simplicity.Sim;

public class mp3Player extends Furniture{
    //Constructor
    public mp3Player(String type, int price, int length, int width) {
        super(type, price, length, width);
    }

    //masih prototype
    public void doAction(Sim sim) {
        sim.listenToMusic();
    }
}
