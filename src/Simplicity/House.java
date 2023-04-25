package Simplicity;
import java.util.ArrayList;
import java.util.List;

public class House {
    private int[] location;
    private List<Room> roomList;

    public House(int x, int y) {
        this.location = new int[] {x, y};
        this.roomList = new ArrayList<>();
        this.roomList.add(new Room("Bedroom", 6, 6));
    }

    public List<Room> getRoomList() {
        return this.roomList;
    }

    public int[] getLocation() {
        return location;
    }
}
