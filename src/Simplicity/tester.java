import java.util.*;
public class tester {
    public static void main(String[] args) {
        Job cook = new Job("cook", 100);
        Job janitor = new Job("janitor", 50);
        Job teacher = new Job("teacher", 75);
        Job CEO = new Job("CEO", 200);
        Job[] arrayOfJobs = {cook, janitor, teacher};
        Sim Kean = new Sim("Kean Nafis Santang", arrayOfJobs, 75);
        try{
            Kean.work(120);
        }
        catch (invalidMultitudeNumber n) {
            System.out.println(n.getMessage());
        }
        System.out.println(Kean.getSimMoney());

        Kean.simChangeJob(CEO);

        System.out.println(Kean.getSimMoney());
        
        // BUAT TESTING INVENTORY
        // Kean.simInventory.addInventory("Egg", 1);
        // Kean.simInventory.addInventory("Book", 5);
        // Kean.simInventory.addInventory("Book", 5);
        // Kean.simInventory.addInventory("Lamp", 2);
        // Kean.simInventory.printInventory();
        // System.out.println(" ");
        // Kean.simInventory.decreaseInventory("Lamp", 2);
        // Kean.simInventory.printInventory();
        // System.out.println(" ");
        // Kean.simInventory.decreaseInventory("Egg", 1);
        // Kean.simInventory.decreaseInventory("Book", 10);
        // Kean.simInventory.printInventory();
        // System.out.println(" ");
        
    }
}
