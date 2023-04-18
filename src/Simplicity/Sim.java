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

    //Constructor
    public Sim(String fullName, Job job, int money, Inventory inv){
        this.simFullName = fullName;
        this.simJob = job;
        simMoney = money;
        simInventory = inv;

        //setting starting numbers for sim needs
        simHunger = 100;
        simMood = 100;
        simHealth = 100;
        simStatus = "Idle";
        lastSleep = 0;
        lastBathroom = 0;
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

    public int getLastBathrom(){
        return lastBathroom;
    }

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

    public void addSimNeed(String needType, int amount){
        if (needType == "Hunger"){
            if (simHunger + amount >= 100){
                simHunger = 100;
            }
            else{
                simHunger = 100;
            }
        }
    }

    //Methods
    public void work(int duration){
        
    }
}
