import Simplicity.*;
import Simplicity.Objects.*;
import java.util.*;


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
        Job magician = new Job("Magician", 15);
        Job chef = new Job("Chef", 30);
        Job police = new Job("Police", 35);
        Job programmer = new Job("Programmer", 45);
        Job doctor = new Job("Doctor", 50);
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
        
        //INGREDIENTS
        FoodIngredients rice = new FoodIngredients("rice", 5, 5);
        FoodIngredients egg = new FoodIngredients("egg", 3, 4);
        FoodIngredients chicken = new FoodIngredients("chicken", 10, 8);
        FoodIngredients meat = new FoodIngredients("meat", 12, 15);
        FoodIngredients spinach = new FoodIngredients("spinach", 3, 2);
        FoodIngredients carrot = new FoodIngredients("carrot", 3, 2);
        FoodIngredients beans = new FoodIngredients("beans", 3, 2);
        FoodIngredients milk = new FoodIngredients("milk", 3, 1);

        //FOOD
        FoodCuisine chickenRice = new FoodCuisine("chicken rice", 16);
        FoodCuisine curryRice = new FoodCuisine("curry rice", 30);
        FoodCuisine beanMilk = new FoodCuisine("bean milk", 5);
        FoodCuisine sauteedVegies = new FoodCuisine("sauteed vegies", 5);
        FoodCuisine steak = new FoodCuisine("steak", 22);
        
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
            put(rice.getType(), rice);
            put(egg.getType(), egg);
            put(chicken.getType(), chicken);
            put(meat.getType(), meat);
            put(spinach.getType(), spinach);
            put(carrot.getType(), carrot);
            put(beans.getType(), beans);
            put(milk.getType(), milk);
        }};

        //TESTING
        gameState = true;
        listOfSims = new ArrayList<>();
        MenuOptions mainMenu = new MenuOptions();
        mainMenu.printMenu();
        mainMenu.addSim(listOfSims, allJobs, world);
        currentSim = mainMenu.changeSim(listOfSims);
        mainMenu.viewSimInventory(currentSim, gameState, listOfSims);
        mainMenu.viewSimInfo(currentSim, gameState, listOfSims);
        
        try{
            currentSim.simBuyItem(purchasableMap, "rice", 1);
            toilet.doAction(currentSim);
            toilet.doAction(currentSim);
            currentSim.work(120);
            
        }
        catch (invalidMultitudeNumber n){
            System.out.println(n.getMessage());
        }
        catch (negativeParameterException e){
            System.out.println(e.getMessage());
        }

        currentSim.simInventory.printInventory();

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

    public void addSim(ArrayList<Sim> simList, Job[] allJobs, World world){
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
        Sim newSim = new Sim(newName, allJobs, world);
        // Sim diberi item awal
        Bed singleBed = new Bed("single bed", 100,4, 1);
        Toilet toilet = new Toilet("toilet", 10, 1, 1);
        Stove gasStove = new Stove("gas stove", 50, 2, 1);
        Desk desk = new Desk("desk", 50, 3, 3);
        newSim.simInventory.addInventory(singleBed, 1);
        newSim.simInventory.addInventory(toilet, 1);
        newSim.simInventory.addInventory(gasStove, 1);
        newSim.simInventory.addInventory(desk, 1);
        // Sim ditambah ke arraylist
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

    

    public void houseUpgrade(Sim currentSim, boolean gameState, ArrayList<Sim> listOfSims) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many rooms do you want to add?");
        int roomTotal = scanner.nextInt();
        System.out.println("How long do you want to wait for the upgrade to finish (in minutes)?");
        int duration = scanner.nextInt();
    
        currentSim.HouseUpgrade(roomTotal, duration);
        System.out.println("House upgrade is in progress...");
        System.out.println("Please wait for " + duration + " minutes for the upgrade to finish.");
    
        try {
            Thread.sleep(duration * 60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    
        System.out.println("House upgrade complete!");

    }
    
}


