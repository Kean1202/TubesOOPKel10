import Simplicity.*;
import Simplicity.Objects.*;

import java.security.InvalidParameterException;
import java.util.*;

import javax.naming.InvalidNameException;

public class Main {
    public static void main(String[] args){
        //Current SIM
        Sim currentSim = null;
        // LIST OF SIMS
        ArrayList<Sim> listOfSims;
        // GAME STATE
        boolean gameState = false;
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
        Bed kingSizeBed = new Bed("king size bed",150, 5, 2);
        Toilet toilet = new Toilet("toilet", 10, 1, 1);
        Stove gasStove = new Stove("gas stove", 50, 2, 1);
        Stove elStove = new Stove("electric stove", 200, 1, 1);
        Desk desk = new Desk("desk", 50, 3, 3);
        Clock clock = new Clock("clock", 10, 1, 1, 0);

        //OBJECTS
        Map<String, PurchasableObject> purchasableMap = new HashMap<String, PurchasableObject>(){{
            put(singleBed.getType(), singleBed);
            put(queenSizeBed.getType(), queenSizeBed);
            put(kingSizeBed.getType(), kingSizeBed);
            put(toilet.getType(), toilet);
            put(gasStove.getType(), gasStove);
            put(elStove.getType(), elStove);
            put(desk.getType(), desk);
            put(clock.getType(), clock);
        }};
        //TESTING
        gameState = true;
        listOfSims = new ArrayList<>();
        MenuOptions mainMenu = new MenuOptions();
        mainMenu.printMenu();
        mainMenu.addSim(listOfSims, allJobs);
        currentSim = mainMenu.changeSim(listOfSims);
        mainMenu.viewSimInventory(currentSim, gameState, listOfSims);
        mainMenu.viewSimInfo(currentSim, gameState, listOfSims);
        
        try{
            currentSim.simBuyItem(purchasableMap, "single bed", 1);
            toilet.doAction(currentSim);
        }
        catch (invalidMultitudeNumber n){
            System.out.println(n.getMessage());
        }
        catch (negativeParameterException e){
            System.out.println(e.getMessage());
        }

        currentSim.simInventory.printInventory();
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

class MenuOptions{
    public void printMenu(){
        System.out.println("========== SIMPLICITY MENU ==========");
        System.out.println("1.  START GAME");
        System.out.println("2.  HELP");
        System.out.println("3.  EXIT");
        System.out.println("4.  VIEW SIM INFO");
        System.out.println("5.  VIEW CURRENT LOCATION");
        System.out.println("6.  VIEW INVENTORY");
        System.out.println("7.  UPGRADE HOUSE");
        System.out.println("8.  MOVE ROOM");
        System.out.println("9.  EDIT ROOM");
        System.out.println("10. ADD SIM");
        System.out.println("11. CHANGE SIM");
        System.out.println("12. LIST OBJECT");
        System.out.println("13. GO TO OBJECT");
        System.out.println("14. ACTION");
        System.out.println("========== /////////////// ==========");
    }

    public void viewSimInfo(Sim mySim, boolean gameState, ArrayList<Sim> simList){
        if (gameState && !simList.isEmpty()){
            System.out.println("Full Name    : " + mySim.getSimName());
            System.out.println("Job          : " + mySim.getSimJobName());
            System.out.println("Health       : " + mySim.getSimHealth());
            System.out.println("Hunger       : " + mySim.getSimHunger());
            System.out.println("Mood         : " + mySim.getSimMood());
            System.out.println("Money        : " + mySim.getSimMoney());
        }
        else{
            System.out.println("You must be in an active game with a minimum of (1) sim to check your sim's information");
        }
    }

    public void viewSimInventory(Sim mySim, boolean gameState, ArrayList<Sim> simList){
        if (gameState && !simList.isEmpty()){
            mySim.simInventory.printInventory();
        }
        else{
            System.out.println("You must be in an active game with a minimum of (1) sim to check your sim's information");
        }
    }

    public void addSim(ArrayList<Sim> simList, Job[] allJobs){
        boolean success = false;
        boolean foundSameName = false;
        String newName = "";
        Scanner inp = new Scanner(System.in);
        // Validasi nama sim
        while (!success){
            foundSameName = false;
            System.out.println("Welcome! Please input your Sim's name: ");
            newName = inp.nextLine();
            // looping buat nyari yang namanya sama
            for (Sim sim: simList){
                if (newName.toLowerCase().equals(sim.getSimName().toLowerCase())){
                    foundSameName = true;
                    System.out.println("There is already another sim with that name, please choose another name!");
                }
            }
            // Bila nama sudah aman, sim ditambahkan
            if (!foundSameName){
                success = true;
            }
        }
        // Sim ditambah ke arraylist
        Sim newSim = new Sim(newName, allJobs);
        simList.add(newSim);
        System.out.println("Sim successfully added");
    }

    public Sim changeSim(ArrayList<Sim> listOfSims){
        Sim newSim = null;
        boolean found = false;
        String name;
        Scanner inp = new Scanner(System.in);
        while (!found){
            System.out.println("Here are you current sims, please choose a sim");
            for (int i = 0; i < listOfSims.size(); i++){
                Sim sim = listOfSims.get(i);
                System.out.println((i+1) + ". " + sim.getSimName());
            }
            System.out.println("Type in the name of the sim you want to switch to: ");
            name = inp.nextLine();
            for (Sim sim: listOfSims){
                if (name.toLowerCase().equals(sim.getSimName().toLowerCase())){
                    found = true;
                    newSim = sim;
                }
            }
            if (!found){
                System.out.println("No sim found with that name!");
                System.out.println();
            }
        }
        System.out.println("Success! you have swapped to " + newSim.getSimName());
        return newSim;
    }
}


