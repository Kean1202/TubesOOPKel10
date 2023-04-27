package Simplicity;

import java.util.*;
import Simplicity.Objects.*;

public class tester {
    public static void main(String[] args) {
        Job cook = new Job("cook", 100);
        Job janitor = new Job("janitor", 50);
        Job teacher = new Job("teacher", 75);
        Job CEO = new Job("CEO", 200);
        Job[] allJobs = Job.getAllJobs(cook, janitor, teacher, CEO);
        Toilet toilet = new Toilet("toilet", 100, 1, 1);
        FoodIngredients egg = new FoodIngredients("egg",1 ,2);
        Sim Kean = new Sim("Kean Nafis Santang", allJobs);
        FoodCuisine Sushi = new FoodCuisine("Sushi", 5);
        // try{
        //     Kean.work(120);
        //     Kean.work(120);
        //     toilet.doAction(Kean);
        // }
        // // jujur gw nyesel make nama gw sendiri buat bikin sim
        // catch (invalidMultitudeNumber n) {
        //     System.out.println(n.getMessage());
        // }
        // System.out.println(Kean.getSimMoney());

        // Kean.simChangeJob(CEO);

        Kean.simCook(Sushi);
        Kean.simInventory.printInventory();

        // BUAT TESTING INVENTORY
        // System.out.println(Kean.getSimMoney());
        // System.out.println(egg.getClass().getSimpleName());

        // Kean.simInventory.addInventory(egg, 5);
        // Kean.simInventory.addInventory(toilet, 1);
        // Kean.simInventory.printInventory();
        // Kean.simInventory.addInventory(egg, 5);
        // Kean.simInventory.decreaseInventory(toilet, 1);
        // Kean.simInventory.decreaseInventory(egg, 5);
        // Kean.simInventory.printInventory();
        // Kean.simInventory.decreaseInventory(egg, 5);
        // Kean.simInventory.printInventory();


        // use this to run the tester: java -classpath out\production\TubesOOPKel10 Simplicity.tester
        
    }
}
