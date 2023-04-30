package Simplicity;


public class WorldTime  {
    private int gameDay;
    private int timeElapsed;

    public WorldTime() {
        //initial day
        gameDay = 1;
    }

    //setter
    public void updateTime(int duration) {
        this.timeElapsed += duration;
    }
    
    //getter
    public int getTimeElapsed() {
        return timeElapsed % 720;
    }

    public int getDay() {
        gameDay = (timeElapsed / 720 ) + 1;
        return gameDay;
    }

    public int getTimeRemaining() {
        getDay();
        return gameDay * 720 - timeElapsed;
    }

    //method
    public void wait(int duration) {
        try {
            Thread.sleep(duration*1000);
            updateTime(duration);
        }
        catch(Exception e) {
            Thread.interrupted();
        }
    }
}
