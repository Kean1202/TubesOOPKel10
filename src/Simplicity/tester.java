import java.util.*;
public class tester {
    public static void main(String[] args) {
        Job cook = new Job("cook", 100);
        Job janitor = new Job("janitor", 50);
        Job[] arrayOfJobs = {cook, janitor};
        Sim Kean = new Sim("Kean Nafis Santang", arrayOfJobs, 1000);
        try{
            Kean.exercise(120);
        }
        catch (invalidMultitudeNumber n){
            System.out.println(n.getMessage());
        }
        
    }
}
