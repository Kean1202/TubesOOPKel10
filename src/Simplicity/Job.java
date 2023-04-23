package Simplicity;

public class Job {
    private String name;
    private int salary;

    public Job(String name, int salary){
        this.name = name;
        this.salary = salary;
    }

    //Setter
    public void setName(String name){
        this.name = name;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    //Getter
    public String getName(){
        return name;
    }

    public int getSalary(){
        return salary;
    }

    //Method
    public static Job[] getAllJobs(Job... jobs) {
        return jobs;
    }
}
