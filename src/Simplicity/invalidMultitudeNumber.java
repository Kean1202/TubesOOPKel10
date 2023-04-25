package Simplicity;

public class invalidMultitudeNumber extends Exception {
    private int amount;

    public invalidMultitudeNumber(int amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return (amount + " is an invalid number for this operation, please input a different amount");
    }
}
