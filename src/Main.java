import Simplicity.*;
import Simplicity.Objects.*;
import Simplicity.Objects.Canvas;
import javax.swing.JOptionPane;

import java.util.*;
import java.util.List;
import java.lang.Object;


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
        boolean allDead = false;
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
            // cek status game masih bisa lanjut atau gk
            gameState = mainMenu.checkState(simList, gameState);
            if (!gameState){
                allDead = true;
            }
            if (gameState){
                // Print menu game
                mainMenu.printMenu(gameState);
                // Validasi input
                System.out.print("Enter your choice: ");
                choice = scanner.nextLine();
                // Jalanin input
                if (choice.equals("12")){
                    currentSim = mainMenu.changeSim(simList);
                }
                else if(choice.equals("7")){
                    if (currentSim.getSimAlive()){
                        mainMenu.houseUpgrade(currentSim);
                    }
                    else{
                        System.out.println("Your sim is dead and is unable to do any actions");
                    }
                }
                else{
                    gameState = mainMenu.executeChoiceInGame(choice, gameState, simList, currentSim, allJobs, world, listOfFoodCuisine,listOfFoodIngredients, listOfFurniture,purchasableMap);
                }

            }

        }
        // berhenti karena exit
        if (choice.equals("3")){
            System.out.println("Exiting game..");

        }
        // berhenti karena sim habis
        else if (allDead){
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
            System.out.println("7.  UPGRADE HOUSE");         // udah
            System.out.println("8.  VISIT HOUSE");           // udah
            System.out.println("9.  MOVE ROOM");            // udah
            System.out.println("10.  EDIT ROOM");           // udah
            System.out.println("11. ADD SIM");              // udah
            System.out.println("12. CHANGE SIM");           // udah
            System.out.println("13. LIST OBJECT");          // udah
            System.out.println("14. GO TO OBJECT");         // udah
            System.out.println("15. ACTION");               // udah
            System.out.println("16. WORK");                 // udah
            System.out.println("17. CHANGE JOB");                 // udah
            System.out.println("18. EXERCISE");                 // udah
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
                if (currentSim.getSimAlive()){
                    viewSimLocation(currentSim);
                }
                else{
                    System.out.println("Your sim is dead and is unable to do any actions");
                }
                break;
            case "6":
                if (currentSim.getSimAlive()){
                    viewSimInventory(currentSim, gameState, listSim);
                }
                else{
                    System.out.println("Your sim is dead and is unable to do any actions");
                }
                break;

            case "8":
                if (currentSim.getSimAlive()){
                    visitHouse(world, currentSim);
                }
                else{
                    System.out.println("Your sim is dead and is unable to do any actions");
                }
                break;
            case "9":
                if (currentSim.getSimAlive()){
                    moveRoom(currentSim);
                }
                else{
                    System.out.println("Your sim is dead and is unable to do any actions");
                }
                break;
            case "10":
                if (currentSim.getSimAlive()){
                    editRoom(currentSim.getCurRoom(), currentSim, purchasableMap);
                }
                else{
                    System.out.println("Your sim is dead and is unable to do any actions");
                }
              break;
            case "11":
                addSim(listSim, allJobs, world);
                break;
            case "13":
                if (currentSim.getSimAlive()){
                    listOfObject(currentSim);
                }
                else{
                    System.out.println("Your sim is dead and is unable to do any actions");
                }
                break;
            case "14":
                if (currentSim.getSimAlive()){
                    goToObject(currentSim);
                }
                else{
                    System.out.println("Your sim is dead and is unable to do any actions");
                }
                break;
            case "15":
                if (currentSim.getSimAlive()){
                    try{
                        action(currentSim, listOfFoodIngredients, listOfFoodCuisine, listOfFurniture);
                    }
                    catch (invalidMultitudeNumber i){
                        System.out.println(i.getMessage());
                    }
                }
                else{
                    System.out.println("Your sim is dead and is unable to do any actions");
                }
                break;
            case "16":
                if (currentSim.getSimAlive()){
                    try{
                        work(currentSim);
                    }
                    catch (invalidMultitudeNumber i){
                        System.out.println(i.getMessage());
                    }
                    catch (negativeParameterException n){
                        System.out.println(n.getMessage());
                    }
                }
                else{
                    System.out.println("Your sim is dead and is unable to do any actions");
                }
                break;
            case "17":
                if (currentSim.getSimAlive()){
                    changeJob(currentSim, allJobs);
                }
                else{
                    System.out.println("Your sim is dead and is unable to do any actions");
                }
                break;
            case "18":
                if (currentSim.getSimAlive()){
                    try{
                        exercise(currentSim);
                    }
                    catch (invalidMultitudeNumber i){
                        System.out.println(i.getMessage());
                    }
                    catch (negativeParameterException n){
                        System.out.println(n.getMessage());
                    }
                }
                else{
                    System.out.println("Your sim is dead and is unable to do any actions");
                }
                break;
            case "0":
                killSim(currentSim);
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
        int numAlive  = 0;
        for (Sim sim: listSim){
            if (sim.getSimAlive()){
                numAlive++;
            }
        }
        if (numAlive <= 0){
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
            if (mySim.getSimAlive()){
                System.out.println("Status      : alive");
            }
            else{
                System.out.println("Status      : dead");
            }

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
            System.out.println("Please input your Sim's name: ");
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
        currentSim.HouseUpgrade();
    }

    public void visitHouse (World world, Sim currentSim){
        if (currentSim.getSimAlive()){
            // syaratnya sim harus hidup
            List<House> houses = world.getworldHouses();
            int i = 1;
            Scanner scanner = new Scanner(System.in);
            for (House house: houses){
                System.out.println(i + ". "+ house.getHouseName());
                i++;
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
                currentSim.setNearbyFurniture(objectDes.getType());
                Point newPoint = new Point(objectDes.getFurnitureLocation().getX(), objectDes.getFurnitureLocation().getY());
                currentSim.setLocation(newPoint);
                System.out.println("You have moved to the " + objectDes.getType());
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
            String itemName;
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
                        itemName = scanner.nextLine();
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
                        if (currentSim.simInventory.isEmpty()){
                            System.out.println("You have no items to place!");
                            break;
                        }
                        currentSim.simInventory.printFurnitureInventory();
                        System.out.println("Choose your item to place: ");
                        itemName = scanner.nextLine();
                        while(!currentSim.simInventory.checkContains(itemName)){
                            System.out.println("Invalid item name!");
                            currentSim.simInventory.printFurnitureInventory();
                            System.out.println("Choose your item to place: ");
                            itemName = scanner.nextLine();
                        }
                        System.out.println("Choose the location to place your item (X): ");
                        int x = Integer.parseInt(scanner.nextLine());
                        System.out.println("Choose the location to place your item (Y): ");
                        int y = Integer.parseInt(scanner.nextLine());

                        Point point = new Point(x, y);
                        Furniture furniture = (Furniture) purchasableMap.get(itemName);
                        currentSim.simPlaceFurniture(point, furniture);
                        break;

                }

        }
        else{
            System.out.println("This sim is dead and is unable to perform any actions");
        }

    }

    public void action(Sim currentSim, ArrayList<FoodIngredients> listOfIngredients, ArrayList<FoodCuisine> listOfFoodCuisine, ArrayList<Furniture> listOfFurniture) throws invalidMultitudeNumber{
        Scanner scanner = new Scanner(System.in);
        Furniture furniture = null;
        if (currentSim.getSimAlive()){
            for (Furniture furn: listOfFurniture){
                if (currentSim.getNearbyFurniture().toLowerCase().equals(furn.getType().toLowerCase())){
                    furniture = furn;
                }
            }
            switch(currentSim.getNearbyFurniture().toLowerCase()){
                case ("single bed"):
                    System.out.println("How long do you want to sleep? ");
                    int singleBedDuration = Integer.parseInt(scanner.nextLine());
                    Bed singleBed = (Bed) furniture;
                    singleBed.doAction(currentSim, singleBedDuration);
                    break;
                case ("queen size bed"):
                    System.out.println("How long do you want to sleep? ");
                    int queenSizeBedDuration = Integer.parseInt(scanner.nextLine());
                    Bed queenSizeBed = (Bed) furniture;
                    queenSizeBed.doAction(currentSim, queenSizeBedDuration);
                    break;
                case ("king size bed"):
                    System.out.println("How long do you want to sleep? ");
                    int kingSizeBedDuration = Integer.parseInt(scanner.nextLine());
                    Bed kingSizeBed = (Bed) furniture;
                    kingSizeBed.doAction(currentSim, kingSizeBedDuration);
                    break;
                case ("comic book"):
                    Book comicBook = (Book) furniture;
                    comicBook.doAction(currentSim);
                    break;
                case ("fantasy novel"):
                    Book fantasyNovel = (Book) furniture;
                    fantasyNovel.doAction(currentSim);
                    break;
                case ("non-fiction book"):
                    Book nfBook = (Book) furniture;
                    nfBook.doAction(currentSim);
                    break;
                case ("clock"):
                    Clock clock = (Clock) furniture;
                    clock.doAction(currentSim);
                    break;
                case ("desk"):
                    Desk desk = (Desk) furniture;
                    System.out.println("Choose a food below");
                    currentSim.simInventory.printFoodInventory();
                    String foodChosen = scanner.nextLine();
                    if (currentSim.simInventory.checkContains(foodChosen)){
                        for (FoodIngredients ingredient: listOfIngredients){
                            Edible food = null;
                            if (ingredient.getType().toLowerCase().equals(foodChosen.toLowerCase())){
                                food = ingredient;
                                desk.doAction(currentSim, food);
                            }
                        }

                        for (FoodCuisine cuisine: listOfFoodCuisine){
                            Edible food = null;
                            if (cuisine.getType().toLowerCase().equals(foodChosen.toLowerCase())){
                                food = cuisine;
                                desk.doAction(currentSim, food);
                            }
                        }

                    }
                    else{
                        System.out.println("No food with that name in your inventory");
                    }
                    break;
                case ("dance pad"):
                    DancePad dancePad = (DancePad) furniture;
                    dancePad.doAction(currentSim);
                    break;

                case ("canvas"):
                    Canvas canvas = (Canvas) furniture;
                    canvas.doAction(currentSim);
                    break;
                case ("meditation mat"):
                    MeditationMat medMat = (MeditationMat) furniture;
                    medMat.doAction(currentSim);
                    break;

                case ("yoga mat"):
                    YogaMat yogaMat = (YogaMat) furniture;
                    yogaMat.doAction(currentSim);
                    break;

                case ("mp3 player"):
                    Mp3Player mp3 = (Mp3Player) furniture;
                    mp3.doAction(currentSim);
                    break;

                case ("tv"):
                    TV tv = (TV) furniture;
                    tv.doAction(currentSim);
                    break;

                case ("electric stove"):
                    Stove electricStove = (Stove) furniture;
                    System.out.println("Please choose something to cook: ");
                    for (FoodCuisine cuisine: listOfFoodCuisine){
                        System.out.println(cuisine.getType());
                    }
                    String cuisineChosen = scanner.nextLine();
                    FoodCuisine fc = null;
                    for (FoodCuisine cuisine: listOfFoodCuisine){
                        if (cuisineChosen.toLowerCase().equals(cuisine.getType().toLowerCase())){
                            fc = cuisine;
                        }
                    }
                    if (fc != null){
                        electricStove.doAction(currentSim, fc);
                    }
                    else{
                        System.out.println("Food not found");
                    }
                    break;

                case ("gas stove"):
                    Stove gasStove = (Stove) furniture;
                    System.out.println("Please choose something to cook: ");
                    for (FoodCuisine cuisine: listOfFoodCuisine){
                        System.out.println(cuisine.getType());
                    }
                    String cuisineChosen2 = scanner.nextLine();
                    FoodCuisine fc2 = null;
                    for (FoodCuisine cuisine: listOfFoodCuisine){
                        if (cuisineChosen2.toLowerCase().equals(cuisine.getType().toLowerCase())){
                            fc2 = cuisine;
                        }
                    }
                    if (fc2 != null){
                        gasStove.doAction(currentSim, fc2);
                    }
                    else{
                        System.out.println("Food not found");
                    }
                    break;

                case ("toilet"):
                    Toilet toilet = (Toilet) furniture;
                    toilet.doAction(currentSim);
                    break;


            }
        }
        else{
            System.out.println("Your sim is dead and is unable to perform any actions");
        }
        System.out.println("Action performed successfully!");
    }

    public void changeJob(Sim currentSim, Job[] allJobs){
        for (int j = 0; j < allJobs.length; j++){
            System.out.println(allJobs[j].getName());
        }
        System.out.println("Select a job you want to switch to: ");
        Scanner scanner = new Scanner(System.in);
        String jobChosen = scanner.nextLine();
        int i = 0;
        boolean found = false;
        Job job = null;
        while (!found && i < allJobs.length){
            if (allJobs[i].getName().toLowerCase().equals(jobChosen.toLowerCase())){
                found = true;
                job = allJobs[i];
            }
            i++;
        }
        if (found && job != null){
            currentSim.simChangeJob(job);
        }
        else{
            System.out.println("Job not found");
        }

    }

    public void exercise(Sim currentSim) throws invalidMultitudeNumber, negativeParameterException{
        if (currentSim.getSimAlive()){
            System.out.println("Input the exercise duration in seconds: ");
            Scanner scanner = new Scanner(System.in);
            int duration = Integer.parseInt(scanner.nextLine());
            currentSim.exercise(duration);
        }
        else{
            System.out.println("This sim is dead and is unable to perform any actions");
        }

    }
    public void killSim(Sim currentSim){
        currentSim.deactivateSim();
    }
}


