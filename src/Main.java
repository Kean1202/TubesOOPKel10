import Simplicity.*;
import Simplicity.Objects.Toilet;

import java.util.*;

public class Main {
    public static void main(String[] args) {
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
        Toilet toilet = new Toilet("toilet", 10, 1, 1);


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

        //GREETINGS
        System.out.println("Welcome to this game!");

        //MENU
        Scanner scanner = new Scanner(System.in);
        int choices = scanner.nextInt();
    }
}
