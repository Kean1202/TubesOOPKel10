package Simplicity;
import java.util.ArrayList;
import java.util.List;

public class House {
    private int[] location;
    private List<Room> roomList;
    private int roomTotal;

    public House(int x, int y) {
        this.location = new int[] {x, y};
        this.roomList = new ArrayList<>();
        this.roomList.add(new Room("Bedroom"));  // ini blm jalan kalo make konstruktor yg sblm gw ubah
    }

    public List<Room> getRoomList() {
        return this.roomList;
    }

    public int[] getLocation() {
        return location;
    }

    public int getRoomTotal() {
        return roomTotal;
    }

    public void setRoomTotal(int roomTotal) {
        this.roomTotal = roomTotal;
    }
}
