import java.util.*;

public class Sim {
    //Attributes
    private String simFullName;
    private Job simJob;
    private int simMoney;
    private Inventory simInventory;
    private int simHunger;
    private int simMood;
    private int simHealth;
    private String simStatus;

    //Attribute untuk ngecek kondisi
    private int lastSleep;
    private int lastBathroom;
    private int timeWorked;

    // get random job
    // TODO implement array of jobs
    public Job getRandomJob(Job[] array){
        int random = new Random().nextInt(array.length);
        return array[random];
    }

    //Constructor
    public Sim(String fullName, Job[] jobList, int money){
        this.simFullName = fullName;
        this.simJob = getRandomJob(jobList);
        simMoney = money;
        simInventory = new Inventory();

        //setting starting numbers for sim needs
        simHunger = 80;
        simMood = 80;
        simHealth = 80;
        simStatus = "Idle";
        lastSleep = 0;
        lastBathroom = 0;
        timeWorked = 0;
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

    // END OF GETTERS

    //Setters
    public void simChangeName(String name){
        simFullName = name;
    }

    public void simChangeJob(Job job){
        simJob = job;
        System.out.println("Your new job is: " + job.getName());
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
            if (needType == "Hunger"){
                if (simHunger + amount >= 100){
                    simHunger = 100;
                }
                else{
                    simHunger += amount;
                }
                System.out.println("Your hunger is now " + simHunger);
            }

            //menambahkan Mood
            else if (needType == "Mood"){
                if (simMood + amount >= 100){
                    simMood = 100;
                }
                else{
                    simMood += amount;
                }
                System.out.println("Your mood is now " + simMood);
            }

            //menambahkan Health
            else if (needType == "Health"){
                if (simHealth + amount >= 100){
                    simHealth = 100;
                }
                else{
                    simHealth += amount;
                }
                System.out.println("Your health is now " + simHealth);
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
            if (needType == "Hunger"){
                if (simHunger - amount <= 0){
                    simHunger = 0;
                }
                else{
                    simHunger -= amount;
                }
                System.out.println("Your hunger is now " + simHunger);
            }

            //menambahkan Mood
            else if (needType == "Mood"){
                if (simMood - amount <= 0){
                    simMood = 0;
                }
                else{
                    simMood -= amount;
                }
                System.out.println("Your mood is now " + simMood);
            }

            //menambahkan Health
            else if (needType == "Health"){
                if (simHealth - amount == 0){
                    simHealth = 0;
                }
                else{
                    simHealth -= amount;
                }
                System.out.println("Your health is now " + simHealth);
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

    // END OF SETTERS

    //Methods
    public void work(int duration) throws invalidMultitudeNumber{
        if (duration % 120 != 0){
            throw new invalidMultitudeNumber(duration);
        }
        else{
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
                            decreaseSimNeed("Mood", 10);
                            decreaseSimNeed("Hunger", 10);
                            simAddMoney(simJob.getSalary()/2);
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

    public void exercise(int duration) throws invalidMultitudeNumber{
        if (duration % 20 != 0){
            throw new invalidMultitudeNumber(duration);
        }
        else{
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

    public void useBathroom(){
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
    

    // END OF METHODS

    // TODO Nested class inventory
    // Kayaknya bakal make hash map
    public class Inventory{
        HashMap<String, Integer> MapInventory;

        public Inventory(){
            MapInventory = new HashMap<String, Integer>();
        }

        public void addInventory(String itemName, Integer itemAmount){
            MapInventory.putIfAbsent(itemName, itemAmount);
            if (MapInventory.containsKey(itemName)){
                MapInventory.replace(itemName, (MapInventory.get(itemName)+itemAmount));
                System.out.println("Added " + itemAmount + " " + itemName + "(s) to your inventory");
            }
            else{
                System.out.print(itemName + "is now in your inventory");
            }
        }

        public void decreaseInventory(String itemName){
            if (MapInventory.containsKey(itemName) && (MapInventory.get(itemName) > 1)){
                MapInventory.replace(itemName, (MapInventory.get(itemName)-1));
            }
            else if (MapInventory.get(itemName) <= 1){
                MapInventory.remove(itemName);
            }
            else{
                System.out.println("The item "+ itemName+ " is not in your inventory!");
            }
        }

        public int getNumberOfItems(){
            return MapInventory.size();
        }

    
    }
}

class negativeParameterException extends Exception{
    private int amount;

    public negativeParameterException(int amount){
        this.amount = amount;
    }

    public String getMessage(){
        return ("Invalid operation, negative number detected: " + amount);
    }
}

class invalidMultitudeNumber extends Exception{
    private int amount;

    public invalidMultitudeNumber(int amount){
        this.amount = amount;
    }

    public String getMessage(){
        return (amount + " is an invalid number for this operation, please input a different amount");
    }
}