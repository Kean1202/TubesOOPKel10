package Simplicity;
import java.time.*;
public class WorldTime {
    private Instant startTime = Instant.now();
    private Duration worldTime;
    private int worldDay;

    public WorldTime() {
        this.worldDay = 1;
    }
    
    public int getWorldDay() {
        Instant now = Instant.now();
        Duration.between(startTime, now);
        refreshTime();
        return worldDay;
    }

    private void refreshTime() {
        worldDay =(int) (worldTime.toSeconds() % 12);
    }

}
