package Simplicity;

public class negativeParameterException extends Exception{
    private int amount;

    public negativeParameterException(int amount){
        this.amount = amount;
    }

    public String getMessage(){
        return ("Invalid operation, negative number detected: " + amount);
    }
}

