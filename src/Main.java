import Simplicity.*;
import Simplicity.Objects.*;

import java.security.InvalidParameterException;
import java.util.*;

import javax.naming.InvalidNameException;

public class Main {
    public static void main(String[] args){
        //INSTANCES

        //LIST OF SIMS
        ArrayList<Sim> listSim = new ArrayList<Sim>();

        //WORLD
        World world = World.getInstance();

        //JOBS
        Job magician = new Job("magician", 15);
        Job chef = new Job("chef", 30);
        Job police = new Job("police", 35);
        Job programmer = new Job("programmer", 45);
        Job doctor = new Job("doctor", 50);
        Job[] allJobs = Job.getAllJobs(chef,magician,police,programmer,doctor);

        //FURNITURE
        Bed singleBed = new Bed("single bed", 100,4, 1);
        Bed queenSizeBed = new Bed("queen size bed",100, 4, 2);
        Bed kingSizeBed = new Bed("king size bed",100, 4, 2);
        Toilet toilet = new Toilet("toilet", 10, 1, 1);

        //OBJECTS
        Map<String, PurchasableObject> purchasableMap = new HashMap<String, PurchasableObject>(){{
            put(singleBed.getType(), singleBed);
            put(queenSizeBed.getType(), queenSizeBed);
            put(kingSizeBed.getType(), kingSizeBed);
            put(toilet.getType(), toilet);
        }};

        //TESTING
        Sim newSim = new Sim("m", allJobs);
        newSim.simInventory.printInventory();
        System.out.println(newSim.getSimMoney());
        
        try{
            newSim.simBuyItem(purchasableMap, "single bed", 1);
            toilet.doAction(newSim);
        }
        catch (invalidMultitudeNumber n){
            System.out.println(n.getMessage());
        }
        catch (negativeParameterException e){
            System.out.println(e.getMessage());
        }

        newSim.simInventory.printInventory();
//
//        if(listSim.size() == 0){
//            System.out.println("No sims created yet!");
//            Scanner str = new Scanner(System.in);
//            System.out.println("Enter your name: ");
//            Sim newSim = new Sim(str.nextLine(), allJobs);
//            listSim.add(newSim);
//            System.out.println("New sim created!");
//        }
//
//        try{
//            listSim.get(0).work(120);
//            listSim.get(0).work(120);
//            toilet.doAction(listSim.get(0));
//        }
//        // jujur gw nyesel make nama gw sendiri buat bikin sim
//        catch (invalidMultitudeNumber n) {
//            System.out.println(n.getMessage());
//        }
//        System.out.println(listSim.get(0).getSimMoney());

        // //GREETINGS
        // System.out.println("Welcome to this game!");

        // //MENU
        // Scanner scanner = new Scanner(System.in);

        // boolean exit = false;
        // while(!exit){
        //     int choices = scanner.nextInt();
        //     switch(choices){
        //         case 1:
        //             while(true){
        //                 System.out.println("i'm gaming rn");
        //             }
        //         case 2:
        //             System.out.println("help");
        //             break;
        //         case 3:
        //             exit = true;
        //             break;
        //         default:
        //             System.out.println("Invalid input!");
        //     }
        // }

    }
}
