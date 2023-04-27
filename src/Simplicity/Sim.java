package Simplicity;

import Simplicity.Objects.*;
import java.util.*;

public class Sim {
    //Attributes
    private String simFullName;
    private Job simJob;
    private int simMoney;
    public Inventory simInventory;
    private int simHunger;
    private int simMood;
    private int simHealth;
    private String simStatus;
    private int[] location;
    private House house;

    //Attribute untuk ngecek kondisi
    private int lastSleep;
    private int lastBathroom;
    private int timeWorked;
    private int daysSinceJobChange;

    // get random job
    // TODO implement array of jobs
    public Job getRandomJob(Job[] array){
        int random = new Random().nextInt(array.length);
        return array[random];
    }

    //Constructor
    public Sim(String fullName, Job[] jobList){
        this.simFullName = fullName;
        this.simJob = getRandomJob(jobList);
        simMoney = 100;
        simInventory = new Inventory();

        //setting starting numbers for sim needs
        simHunger = 80;
        simMood = 80;
        simHealth = 80;
        simStatus = "Idle";
        lastSleep = 0;
        lastBathroom = 0;
        timeWorked = 0;
        daysSinceJobChange = 0;
    }

    //Getters
    public String getSimName(){
        return simFullName;
    }

    public String getSimJobName(){
        return simJob.getName();
    }

    public int getSimSalary(){
        return simJob.getSalary();
    }

    public int getSimMoney(){
        return simMoney;
    }

    public int getSimHunger(){
        return simHunger;
    }

    public int getSimMood(){
        return simMood;
    }

    public int getSimHealth(){
        return simHealth;
    }

    public String getSimStatus(){
        return simStatus;
    }

    public int getLastSleep(){
        return lastSleep;
    }

    public int getLastBathroom(){
        return lastBathroom;
    }

    public int getTimeWorked(){
        return timeWorked;
    }

    public int getLastJobChange(){
        return daysSinceJobChange;
    }

    public int[] getLocation() {
        return location;
    }

    

    // END OF GETTERS

    //Setters
    public void simChangeName(String name){
        simFullName = name;
    }

    public void simChangeJob(Job job){
        // 12 * 60 = 12 menit dalam detik
        if (getTimeWorked() >= 30){
            // harus bisa bayar setengah gaji dari gaji pekerjaan baru
            if (getSimMoney() >= job.getSalary()/2){
                simJob = job;
                simDecreaseMoney(job.getSalary()/2);
                System.out.println("Success! Your new job is: " + job.getName());
                daysSinceJobChange = 0;
            }
            else{
                System.out.println("You don't have enough money to become a " + job.getName());
            }
        }
        else{
            System.out.println("You haven't worked long enough in your current job to change jobs");
        }
        
    }

    public void simAddMoney(int amount){
        simMoney += amount;
    }

    public void simDecreaseMoney(int amount){
        simMoney -= amount;
    }

    // ada exception buat angka negatif
    public void addSimNeed(String needType, int amount) throws negativeParameterException{
        if (amount < 0){
            throw new negativeParameterException(amount);
        }
        else{
            //menambahkan hunger
            switch (needType) {
                case "Hunger": 
                    if (simHunger + amount >= 100) {
                        simHunger = 100;
                    } else {
                        simHunger += amount;
                    }
                    System.out.println("Your hunger is now " + simHunger);
                    break;

                //menambahkan Mood
                case "Mood":
                    if (simMood + amount >= 100) {
                        simMood = 100;
                    } else {
                        simMood += amount;
                    }
                    System.out.println("Your mood is now " + simMood);
                    break;

                //menambahkan Health
                case "Health":
                    if (simHealth + amount >= 100) {
                        simHealth = 100;
                    } else {
                        simHealth += amount;
                    }
                    System.out.println("Your health is now " + simHealth);
                    break;
            }
        }
        
    } // end of adding needs

    // ada exception buat angka negatif
    public void decreaseSimNeed(String needType, int amount) throws negativeParameterException{
        if (amount < 0){
            throw new negativeParameterException(amount);
        }
        else{
            //menambahkan hunger
            switch (needType) {
                case "Hunger":
                    if (simHunger - amount <= 0) {
                        simHunger = 0;
                    } else {
                        simHunger -= amount;
                    }
                    System.out.println("Your hunger is now " + simHunger);
                    break;

                //menambahkan Mood
                case "Mood":
                    if (simMood - amount <= 0) {
                        simMood = 0;
                    } else {
                        simMood -= amount;
                    }
                    System.out.println("Your mood is now " + simMood);
                    break;

                //menambahkan Health
                case "Health":
                    if (simHealth - amount == 0) {
                        simHealth = 0;
                    } else {
                        simHealth -= amount;
                    }
                    System.out.println("Your health is now " + simHealth);
                    break;
            }
        }
        
    } // end of decreasing needs


    //ganti status
    public void simChangeStatus(String newStatus){
        simStatus = newStatus;
    } 

    public void changeLastBathroom(int amount){
        lastBathroom += amount;
    }

    public void changeLastSleep(int amount){
        lastSleep += amount;
    }

    public void changeTimeWorked(int amount){
        timeWorked += amount;
    }

    public void setLocation(int[] location) {
        this.location = location;
    }

    // END OF SETTERS

    //Methods

    // Method untuk cek udh dapet gaji ato blm

    // Method untuk kerja
    public void work(int duration) throws invalidMultitudeNumber{
        if (duration % 120 != 0){
            throw new invalidMultitudeNumber(duration);
        }
        else{
            //ganti status sim
            simChangeStatus("Working");
            System.out.println("You are currently working as a " + getSimJobName());
            Thread thread = new Thread(new Runnable(){
                public void run(){
                    int repetition = duration / 30;
                    for (int i = 0; i<repetition; i++){
                        try{
                            // Biar keren gw bikin make '....'
                            for (int j = 0; j<30/6; j++){
                                System.out.print("...");
                                Thread.sleep(30/5 * 1000);
                            }
                            System.out.println("");
                            Thread.sleep(30 * 1000);
                            decreaseSimNeed("Mood", 10);
                            decreaseSimNeed("Hunger", 10);
                            //ganti jam kerja sim
                            changeTimeWorked(30);
                            if(getTimeWorked() == 240){
                                simAddMoney(simJob.getSalary());
                                System.out.println("You have worked for 4 minutes.");
                                System.out.println("You earned " + simJob.getSalary() + " dollars.");
                                System.out.println("Your money: " + getSimMoney());
                            }
                            else{
                                System.out.println("You have worked for "+ (float)getTimeWorked()/60 + " minutes.");
                            }
                        }
                        catch (InterruptedException e){
                            System.out.println(e.getMessage());
                        }
                        catch (negativeParameterException n){
                            System.out.println(n.getMessage());
                        }

                    }


                }
            });
            thread.start();
            //supaya dia nunggu thread lain
            try{
                thread.join();
            }
            catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }

    //Method untuk olahraga
    public void exercise(int duration) throws invalidMultitudeNumber{
        if (duration % 20 != 0){
            throw new invalidMultitudeNumber(duration);
        }
        else{
            simChangeStatus("Exercising");
            Thread thread = new Thread(new Runnable(){
                public void run(){
                    int repetition = duration / 20;
                    for (int i = 0; i<repetition; i++){
                        try{
                            System.out.println("Working out!");
                            // Biar keren gw bikin make '....'
                            for (int j = 0; j<20/4; j++){
                                System.out.print("...");
                                Thread.sleep(20/5 * 1000);
                            }
                            System.out.println("");
                            addSimNeed("Health", 5);
                            addSimNeed("Mood", 10);
                            decreaseSimNeed("Hunger", 5);
                        }
                        catch (InterruptedException e){
                            System.out.println(e.getMessage());
                        }
                        catch (negativeParameterException n){
                            System.out.println(n.getMessage());
                        }
                    }
                    
                }
            });

            thread.start();
            // supaya dia nunggu thread lain
            try{
                thread.join();
            }
            catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    // Method untuk tidur
    public void sleep(int duration) throws invalidMultitudeNumber {
        if (duration % (4*60) != 0){
            throw new invalidMultitudeNumber(duration);
        }
        else{
            simChangeStatus("Sleeping");
            Thread thread = new Thread(new Runnable(){
                public void run(){
                    int repetition = duration / (4*60);
                    for (int i = 0; i<repetition; i++){
                        try{
                            System.out.println("Zzzz...");
                            for (int j = 0; j<240/48; j++){
                                System.out.print("...");
                                Thread.sleep(240/5 * 1000);
                            }
                            System.out.println("");
                            addSimNeed("Mood", 30);
                            addSimNeed("Health", 20);
                        }
                        catch (InterruptedException e){
                            System.out.println(e.getMessage());
                        }
                        catch (negativeParameterException n){
                            System.out.println(n.getMessage());
                        }
                    }
                    
                }
            });
            thread.start();
            // supaya dia nunggu thread lain
            try{
                thread.join();
            }
            catch (InterruptedException e){
                System.out.println(e.getMessage());
            }        
        }
    }
    
    // Method untuk memeriksa kapan terakhir tidur
    public void checkLastSleep(){
        if (lastBathroom >= 10 * 60){    
            System.out.println("You haven't slept yet, please get some rest !");
            try{
                decreaseSimNeed("Mood", 5);
                decreaseSimNeed("Health", 5);
            }
            catch (negativeParameterException n){
                System.out.println(n.getMessage());
            }
        }
    }

    //Method untuk ke kamar mandi
    public void useBathroom(){
        simChangeStatus("In the bathroom");
        Thread thread = new Thread(new Runnable(){
            public void run(){
                try{
                    System.out.println("Using the bathroom");
                    for (int j = 0; j<10/2; j++){
                        System.out.print("...");
                        Thread.sleep(10/5 * 1000);
                    }
                    System.out.println("");
                    decreaseSimNeed("Hunger", 20);
                    addSimNeed("Mood", 10);
                }
                catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
                catch (negativeParameterException n){
                    System.out.println(n.getMessage());
                }
                
            }
        }); 
        thread.start();
        // supaya dia nunggu thread lain
        try{
            thread.join();
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        
    }

    // Method untuk memeriksa kapan terakhir ke toilet
    public void checkLastBathroom(){
        if (lastBathroom >= 4 * 60){    //4*60 adalah 4 menit dalam detik
            System.out.println("You forgot to go to the bathroom after you ate!");
            try{
                decreaseSimNeed("Mood", 5);
                decreaseSimNeed("Health", 5);
            }
            catch (negativeParameterException n){
                System.out.println(n.getMessage());
            }
        }
    }

    // Method untuk Makan
    public void simEat(FoodCuisine food){
        //ngurangin waktu world
        //World.decreaseTime(30);
        Thread thread = new Thread(new Runnable(){
            public void run(){
                try{
                    System.out.println("Eating");
                    for (int j = 0; j<30/2; j++){
                        System.out.print("...");
                        Thread.sleep(30/15 * 1000);
                    }
                    System.out.println("");
                    decreaseSimNeed("Hunger", food.getRepletion());
                }
                catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
                catch (negativeParameterException n){
                    System.out.println(n.getMessage());
                }
                
            }
        }); 
        thread.start();

        try{
            thread.join();
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }


    }

    //Method untuk masak
    public void simCook(FoodCuisine food){
        Thread thread = new Thread(new Runnable(){
            public void run(){
                try{
                    System.out.println("Cooking");
                    for (int j = 0; j<((food.getRepletion()*1.5)/2); j++){
                        System.out.print("...");

                        //ERROR -> solved, cuman typo harusnya repletion bukan repletition
                        double sleepValDouble = (food.getRepletion()*1.5)/(food.getRepletion()%2) * 1000;
                        long sleepValLong = (long) sleepValDouble;
                        Thread.sleep(sleepValLong);
                    }
                    System.out.println("");
                    addSimNeed("Mood", 10);

                    //menambahkan makanan ke inventory
                    //ERROR -> solved
                    simInventory.addInventory(food, 1);
                } catch (negativeParameterException n) {
                    System.out.println(n.getMessage());
                } catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
                
            }
        }); 
        thread.start();

        try{
            thread.join();
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

    }

    public void simBuyItem(Map<String, PurchasableObject> objectMap,  String itemName, int amount) throws negativeParameterException, invalidMultitudeNumber{
        if (amount < 0){
            throw new negativeParameterException(amount);
        }
        else if(amount == 0){
            throw new invalidMultitudeNumber(amount); 
        }
        else{
            int time = new Random().nextInt(6)* 30 * 1000;
            PurchasableObject object = objectMap.get(itemName);
            if (object != null){
                if (object.getPrice()*amount <= getSimMoney()){
                    Thread thread = new Thread(new Runnable(){
                        public void run(){
                            try{
                                Thread.sleep(time);
                                simDecreaseMoney(object.getPrice()*amount);
                                simInventory.addInventory((SimplicityObject)object, amount);
                                System.out.println("You have bought " + ((SimplicityObject) object).getType() + " for " + object.getPrice() + " Simplicity Dollars");        
                            }
                            catch (InterruptedException e){
                                System.out.println(e.getMessage());
                            }
                        }
                    });
                    thread.start();
                }
                else{
                    System.out.println("You don't have enough money to buy " + ((SimplicityObject) object).getType());
                }
            }
            else{
                System.out.println("Item not found");
            }
        }
    }

    //method untuk berkunjung
    public void simVisit(House destination) {
        simChangeStatus("On the way to visit " + destination.toString());
        double distance = Math.sqrt(Math.pow(destination.getLocation()[0] - getLocation()[0], 2)
                + Math.pow(destination.getLocation()[1] - getLocation()[1], 2));
        int time = (int) distance;
        Thread thread = new Thread(() -> {
            try {
                System.out.println("Visiting " + destination.toString());
                for (int j = 0; j < time; j++) {
                    System.out.print("...");
                    Thread.sleep(1000);
                }
                System.out.println("");
                addSimNeed("Mood", 10);
                decreaseSimNeed("Hunger", 10);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            } catch (negativeParameterException n) {
                System.out.println(n.getMessage());
            }
        });
        thread.start();
        // tunggu thread lain selesai
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void HouseUpgrade(int roomTotal) {
        try {
            // Tunggu selama 18 menit
            Thread.sleep(18 * 60 * 1000);
    
            // Tambahkan ruangan ke dalam house
            house.setRoomTotal(house.getRoomTotal() + roomTotal);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }






    // TODO yang implementasi waktu bikin perhitungan waktu per hari dan pergantian hari
    

    // END OF METHODS

    // Diimplementasikan dengan hash map
    public class Inventory{
        HashMap<SimplicityObject, Integer> MapInventory;

        // TODO GANTI DARI STRING KE OBJECT
        public Inventory(){
            MapInventory = new HashMap<SimplicityObject, Integer>();
        }

        public void addInventory(SimplicityObject item, Integer itemAmount){
            if (MapInventory.containsKey(item)){
                MapInventory.replace(item, (MapInventory.get(item)+itemAmount));
                System.out.println("Added " + itemAmount + " " + item.getType() + "(s) to your inventory");
            }
            else{
                MapInventory.putIfAbsent(item, itemAmount);
                System.out.println(item.getType()+ " is now in your inventory" + " (" + itemAmount + ")");
            }
        }

        public void decreaseInventory(SimplicityObject item, int itemAmount){
            if (MapInventory.containsKey(item) && (MapInventory.get(item)-itemAmount >= 1)){
                MapInventory.replace(item, (MapInventory.get(item)-itemAmount));
            }
            else if (MapInventory.get(item)-itemAmount <= 0){
                MapInventory.remove(item);
            }
            else{
                System.out.println("The item "+ item.getType()+ " is not in your inventory!");
            }
        }

        public int getNumberOfItems(){
            return MapInventory.size();
        }

        public void printInventory(){
            if (!MapInventory.isEmpty()){
                System.out.println(getSimName() + "'s Inventory: ");
                for (Map.Entry<SimplicityObject, Integer> entry: MapInventory.entrySet()){
                    System.out.println(entry.getKey().getType() + ", amount: " + entry.getValue());
                }
            }

            else{
                System.out.println("Your inventory is empty");
            }
        }
    
    }
}

