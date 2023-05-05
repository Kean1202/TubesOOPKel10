package Simplicity.Objects;

import Simplicity.Sim;

public class Clock extends Furniture {
    private int time;
    
    public Clock(String type, int price, int length, int width, int time) {
        super(type, price, length, width);
        this.time = time;
    }
    
    public void setTime(int time) {
        this.time = time;
    }
    
    public int getTime() {
        return time;
    }
    
    //masih prototype
    public void doAction(Sim sim) {
        sim.checkTime();
    }
}
