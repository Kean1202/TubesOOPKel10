import Simplicity.*;
import Simplicity.Objects.*;
import Simplicity.Objects.Canvas;
import javax.swing.JOptionPane;

import java.util.*;
import java.util.List;


public class Main {
    public static void main(String[] args){
        //Current SIM
        Sim currentSim = null;
        // LIST OF SIMS
        ArrayList<Sim> simList = new ArrayList<>();;
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

        //OBJECTS

        //FURNITURE
        Bed singleBed = new Bed("single bed", 100,4, 1);
        Bed queenSizeBed = new Bed("queen size bed",100, 4, 2);
        Bed kingSizeBed = new Bed("king size bed",150, 5, 2);
        Toilet toilet = new Toilet("toilet", 10, 1, 1);
        Stove gasStove = new Stove("gas stove", 50, 2, 1);
        Stove elStove = new Stove("electric stove", 200, 1, 1);
        Desk desk = new Desk("desk", 50, 3, 3);
        Clock clock = new Clock("clock", 10, 1, 1, 0);
        Book comicBook = new Book("comic book", 0, 0, 0, "Comic book");
        Book fantasyNovel = new Book("fantasy novel", 0, 0, 0, "Fantasy novel");
        Book nonficBook = new Book("non-fiction book", 0, 0, 0, "Non-fiction");
        Canvas canvas = new Canvas("canvas", 0, 0, 0);
        DancePad dancePad = new DancePad("dance pad", 0, 0, 0);
        MeditationMat meditationMat = new MeditationMat("meditation mat", 0, 0, 0);
        Mp3Player mp3Player = new Mp3Player("mp3 player", 100, 1, 1);
        TV tv = new TV("TV", 0, 0, 0);
        YogaMat yogaMat = new YogaMat("yoga mat", 0, 0, 0);
        ArrayList<Furniture> listOfFurniture = new ArrayList<>();
        listOfFurniture.add(singleBed);
        listOfFurniture.add(queenSizeBed);
        listOfFurniture.add(kingSizeBed);
        listOfFurniture.add(toilet);
        listOfFurniture.add(gasStove);
        listOfFurniture.add(elStove);
        listOfFurniture.add(desk);
        listOfFurniture.add(clock);
        listOfFurniture.add(comicBook);
        listOfFurniture.add(fantasyNovel);
        listOfFurniture.add(nonficBook);
        listOfFurniture.add(canvas);
        listOfFurniture.add(dancePad);
        listOfFurniture.add(meditationMat);
        listOfFurniture.add(mp3Player);
        listOfFurniture.add(tv);
        listOfFurniture.add(yogaMat);

        //INGREDIENTS
        FoodIngredients rice = new FoodIngredients("rice", 5, 5);
        FoodIngredients egg = new FoodIngredients("egg", 3, 4);
        FoodIngredients chicken = new FoodIngredients("chicken", 10, 8);
        FoodIngredients meat = new FoodIngredients("meat", 12, 15);
        FoodIngredients spinach = new FoodIngredients("spinach", 3, 2);
        FoodIngredients carrot = new FoodIngredients("carrot", 3, 2);
        FoodIngredients beans = new FoodIngredients("beans", 3, 2);
        FoodIngredients milk = new FoodIngredients("milk", 3, 1);
        ArrayList<FoodIngredients> listOfFoodIngredients = new ArrayList<>();
        listOfFoodIngredients.add(rice);
        listOfFoodIngredients.add(egg);
        listOfFoodIngredients.add(chicken);
        listOfFoodIngredients.add(meat);
        listOfFoodIngredients.add(spinach);
        listOfFoodIngredients.add(carrot);
        listOfFoodIngredients.add(beans);
        listOfFoodIngredients.add(milk);

        //FOOD
        FoodCuisine chickenRice = new FoodCuisine("chicken rice", 16);
        FoodCuisine curryRice = new FoodCuisine("curry rice", 30);
        FoodCuisine beanMilk = new FoodCuisine("bean milk", 5);
        FoodCuisine sauteedVegies = new FoodCuisine("sauteed vegies", 5);
        FoodCuisine steak = new FoodCuisine("steak", 22);
        ArrayList<FoodCuisine> listOfFoodCuisine = new ArrayList<>();
        listOfFoodCuisine.add(chickenRice);
        listOfFoodCuisine.add(curryRice);
        listOfFoodCuisine.add(beanMilk);
        listOfFoodCuisine.add(sauteedVegies);
        listOfFoodCuisine.add(steak);

        //PURCHASABLE
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



        // Mulai main gamenya
        gameState = false;
        MenuOptions mainMenu = new MenuOptions();
        Scanner scanner = new Scanner(System.in);
        String choice = null;
        boolean lostGame = false;
        while (!gameState){
            mainMenu.printMenu(gameState);
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();
            if (choice.equals("3")){
                // langsung exit
                gameState = true;
            }
            // pilihan non-exit
            else{
                gameState = mainMenu.executeChoiceOutsideGame(choice, gameState);
            }
        }
        if (!choice.equals("3")){
            //kondisi pengguna tidak memilih exit langsung
            // Add sim pertama
            System.out.println("Welcome to Simplicity! Let's add your first Sim!");
            mainMenu.addSim(simList, allJobs, world);
            currentSim = simList.get(0);
        }
        else{
            gameState = false;
        }

        while (gameState){
            // Print menu game
            mainMenu.printMenu(gameState);
            // cek status game masih bisa lanjut atau gk
            gameState = mainMenu.checkState(simList, gameState);
            // Validasi input
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();
            //testing
//            List<House> houses = world.getworldHouses();
//            for (House house: houses){
//                System.out.println(house.getHouseName());
//            }
            // Jalanin input
            gameState = mainMenu.executeChoiceInGame(choice, gameState, simList, currentSim, allJobs, world, listOfFoodCuisine,listOfFoodIngredients, listOfFurniture,purchasableMap);
        }
        // berhenti karena exit
        if (choice.equals("3")){
            System.out.println("Exiting game..");

        }
        // berhenti karena sim habis
        else if (simList.isEmpty()){
            System.out.println("All of your sims are dead, GAME OVER");
        }


    }

}

class MenuOptions{
    public boolean startGame(){
        return true ;
    }

    public void printMenu(boolean gameState){
        if (gameState){
            System.out.println("========== SIMPLICITY MENU ==========");
            System.out.println("1.  START GAME");
            System.out.println("2.  HELP");                     // udah
            System.out.println("3.  EXIT");                     // udah
            System.out.println("4.  VIEW SIM INFO");            // udah
            System.out.println("5.  VIEW CURRENT LOCATION");    // udah
            System.out.println("6.  VIEW INVENTORY");           // udah
            System.out.println("7.  UPGRADE HOUSE");         // belum kelar
            System.out.println("8.  VISIT HOUSE");           // udah
            System.out.println("9.  MOVE ROOM");            // udah
            System.out.println("10.  EDIT ROOM");           // tinggal pindahBarang
            System.out.println("11. ADD SIM");              // udah
            System.out.println("12. CHANGE SIM");           // udah
            System.out.println("13. LIST OBJECT");          // udah
            System.out.println("14. GO TO OBJECT");         // udah
            System.out.println("15. ACTION");               // belum ->
            System.out.println("16. WORK");                 // udah
            System.out.println("========== /////////////// ==========");
            System.out.println("");
        }
        else{
            System.out.println("========== SIMPLICITY MENU ==========");
            System.out.println("1.  START GAME");
            System.out.println("2.  HELP");
            System.out.println("3.  EXIT");
            System.out.println("========== /////////////// ==========");
            System.out.println("");
        }

    }

    //method untuk memilih option ketika sudah di dalam game (In Progress)
    public boolean executeChoiceInGame(String choice, boolean gameState, ArrayList<Sim> listSim, Sim currentSim, Job[] allJobs, World world,  ArrayList<FoodCuisine> listOfFoodCuisine, ArrayList<FoodIngredients> listOfFoodIngredients, ArrayList<Furniture> listOfFurniture, Map<String, PurchasableObject> purchasableMap){
        switch(choice) {
            case "1":
                if (gameState){
                    System.out.println("The game is already running...");
                }
                else{
                    gameState = startGame();
                }
                break;
            case "2":
                printHelp();
                break;
            case "3":
                exitGame(gameState);
                break;
            case "4":
                viewSimInfo(currentSim, gameState, listSim);
                break;
            case "5":
                viewSimLocation(currentSim);
                break;
            case "6":
                viewSimInventory(currentSim, gameState, listSim);
                break;
            case "7":
                houseUpgrade(currentSim);
                break;
            case "8":
                visitHouse(world, currentSim);
                break;
            case "9":
                moveRoom(currentSim);
                break;
          case "10":
              editRoom(currentSim.getCurRoom(), currentSim, purchasableMap);
              break;
            case "11":
                addSim(listSim, allJobs, world);
                break;
            case "12":
                changeSim(listSim);
                break;
            case "13":
                listOfObject(currentSim);
                break;
          case "14":
              goToObject(currentSim);
              break;
//          case "15":
//              action();
//              break;
            case "16":
                try{
                    work(currentSim);
                }
                catch (invalidMultitudeNumber i){
                    System.out.println(i.getMessage());
                }
                catch (negativeParameterException n){
                    System.out.println(n.getMessage());
                }

                break;
            case "0":
                break;
            default:
                System.out.println("Invalid choice. Please input a number between 1-15.");
            }
        return gameState;

    }

    // Method untuk menerima command sebelum gameState = true
    public boolean executeChoiceOutsideGame(String choice, boolean gameState){
        switch (choice){
            case "1":
                if (gameState){
                    System.out.println("The game is already running");
                }
                else{
                    gameState = startGame();
                }
                break;
            case "2":
                    printHelp();
                    break;
            case "3":
                    exitGame(gameState);
                    break;
            default:
                    System.out.println("Invalid choice. please choose a number between 1-3");
        }

        return gameState;
    }

    public boolean checkState(ArrayList<Sim> listSim, boolean gameState){
        if (listSim.isEmpty()){
            gameState = exitGame(gameState);
        }
        return gameState;
    }
    public void printHelp(){
        System.out.println("A GUIDE TO SIMPLICITY");
        System.out.println("-Start the game to enable gameplay-");
        System.out.println("-You start the game by creating your very first Sim");
        System.out.println("-Every sim acts just like you! They have a meter representing their mood, health, and hunger-");
        System.out.println("-Every sim starts with 80 of each status. the higher the number, the better-");
        System.out.println("-You can command your sim to do certain things, such as working, cooking, and eating-");
        System.out.println("-Each action will take time. Once you finish them, your Sim's mood might increase or decrease-");
        System.out.println("-You can also add new Sims to your game, the goal is to make sure none of the sims' status goes to 0-");
        System.out.println("-If any of your Sims' status drops down to 0, the sim dies. If you run out of Sims, you lose-");
        System.out.println("-You can choose actions by typing in the number according to the menu printed on the screen, Goodluck!-");
        System.out.println("");
        System.out.println("");
    }

    public boolean exitGame(boolean gameState){
        return false;
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
    
    public void viewSimLocation(Sim mySim){
        System.out.println("Your current location is at " + mySim.getCurHouse().getHouseName() + " " + mySim.getCurRoom().getRoomName().toLowerCase());
    }
    
    public void viewSimInventory(Sim mySim, boolean gameState, ArrayList<Sim> simList){
        if (gameState && !simList.isEmpty() && mySim.getSimAlive()){
            mySim.simInventory.printInventory();
        }
        else if (!mySim.getSimAlive()){
            System.out.println("This sim is dead and is unable to perform any actions");
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
        // HOUSE
        boolean foundSame = true;
        int x, y, secondBool;
        x = 0;
        y = 0;
        List<House> listHouse = world.getworldHouses();
        while (foundSame){
            secondBool = 0;
            Random rand = new Random();
            x = rand.nextInt(64);
            y = rand.nextInt(64);
            for (House house: listHouse){
                if (house.getLocation().getX() == x && house.getLocation().getY() == y){
                    foundSame = true;
                    secondBool = 1;
                }
            }
            if (foundSame && secondBool != 1){
                foundSame = false;
            }
        }

        // Sim ditambah ke arraylist
        Sim newSim = new Sim(newName, allJobs, world, x, y);
        // Masukin house kw world
        world.addworldHouse(newSim.getSimHouse());
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
                    if (sim.getSimAlive()){
                        found = true;
                        newSim = sim;
                    }
                    else{
                        System.out.println("This Sim is dead. You are unable to switch to a dead Sim");
                    }
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

    public void listOfObject(Sim currentSim){
        System.out.println("========== LIST OF OBJECTS ==========");
        currentSim.getCurRoom().displayFurniture();
        System.out.println("========== /////////////// ==========");
    }

    public void houseUpgrade(Sim currentSim) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many rooms do you want to add?");
        int roomTotal = scanner.nextInt();
        if (currentSim != null) {
            currentSim.HouseUpgrade(roomTotal);
        } else {
            System.out.println("currentSim is null");
        }

    }

    public void visitHouse (World world, Sim currentSim){
        if (currentSim.getSimAlive()){
            // syaratnya sim harus hidup
            List<House> houses = world.getworldHouses();
            int i = 1;
            Scanner scanner = new Scanner(System.in);
            for (House house: houses){
                System.out.println(i + ". "+ house.getHouseName());
            }
            System.out.println("Choose a house number: ");
            int chosenHouse = Integer.parseInt(scanner.nextLine());
            if (chosenHouse <= houses.size() && chosenHouse > 0){
                House destination = houses.get(chosenHouse-1);
                currentSim.simVisit(destination);
            }
            else{
                System.out.println("Sorry, that house number does not exist");
            }
        }
        else{
            //sim udah mati
            System.out.println("This sim is dead and is unable to perform any actions");
        }


    }

    public void moveRoom(Sim currentSim){
        if (currentSim.getSimAlive()){
            currentSim.simMoveRoom();
        }
        else{
            System.out.println("This sim is dead and is unable to perform any actions");
        }
    }

    public void goToObject(Sim currentSim){
        if (currentSim.getSimAlive()){
            Scanner scanner = new Scanner(System.in);
            ArrayList<Furniture> listFurniture = currentSim.getCurRoom().getFurniture();
            System.out.println("List of objects in your current room : ");
            int i = 1;
            for(Furniture furniture : listFurniture){
                System.out.println(i + ". " +  furniture.getType());
                i++;
            }
            System.out.print("Insert the number of the object you want to go to:  ");
            int numFurniture = scanner.nextInt();
            if(numFurniture <= listFurniture.size()){
                Furniture objectDes = listFurniture.get(numFurniture-1);
                currentSim.getLocation().setX(objectDes.getFurnitureLocation().getX());
                currentSim.getLocation().setY(objectDes.getFurnitureLocation().getY());
            }
            //kalau input numFurniture lebih dari total objek di ruangan
            else{
                System.out.println("Input invalid. Please choose an available number!");
            }
        }
        else{
            System.out.println("This sim is dead and is unable to perform any actions");
        }

    }

    public void work(Sim currentSim) throws invalidMultitudeNumber, negativeParameterException{
        if (currentSim.getSimAlive()){
            System.out.println("Input the work duration in seconds: ");
            Scanner scanner = new Scanner(System.in);
            int duration = Integer.parseInt(scanner.nextLine());
            currentSim.work(duration);
        }
        else{
            System.out.println("This sim is dead and is unable to perform any actions");
        }


    }

    public void editRoom(Room room, Sim currentSim,  Map<String, PurchasableObject> purchasableMap){
        if (currentSim.getSimAlive()){
            Scanner scanner = new Scanner(System.in);
            String choice;
                System.out.println("Choose the option you want to do:");
                System.out.println("1. Buy a new item");
                System.out.println("2. Place an item");
                System.out.print("Enter your choice: ");
                choice = scanner.nextLine();
                switch(choice) {
                    case "1":
                        System.out.println("Available items to purchase:");
                        currentSim.listPurchasableObjects(purchasableMap);
                        System.out.print("Enter the name of the item to purchase: ");
                        String itemName = scanner.nextLine();
                        boolean foundName = false;
                        System.out.print("Enter the amount to purchase: ");
                        int amount = scanner.nextInt();

                        try {
                            currentSim.simBuyItem(purchasableMap, itemName, amount);
                        } catch (negativeParameterException e) {
                            e.printStackTrace();
                        } catch (invalidMultitudeNumber e) {
                            e.printStackTrace();
                        }
                        break;

                    case "2":
                        currentSim.pindahBarang();

                }

        }
        else{
            System.out.println("This sim is dead and is unable to perform any actions");
        }

    }
}


