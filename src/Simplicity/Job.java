public class Job {
    private String name;
    private int salary;
    
    public Job(String name, int salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }

    public int getSalary(){
        return salary;
    }
}
