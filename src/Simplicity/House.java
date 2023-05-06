package Simplicity;
import java.util.ArrayList;
import java.util.List;


public class House {
    private String name;
    private Point location;
    private List<Room> roomList;
    private int roomTotal;

    public House(int x, int y, String name) {
        this.location = new Point(x,y);
        this.roomList = new ArrayList<>();
        this.roomList.add(new Room("Bedroom"));  // ini blm jalan kalo make konstruktor yg sblm gw ubah
        this.name = name;
    }

    public List<Room> getRoomList() {
        return this.roomList;
    }

    public Point getLocation() {
        return location;
    }

    public int getRoomTotal() {
        return roomTotal;
    }

    public String getHouseName() {
        return name;
    }
    
    public void setRoomTotal(int roomTotal) {
        this.roomTotal = roomTotal;
    }

    public void setHouseName(String houseName) {
        this.name = houseName;
    }

    public void addRoom() {
 
    }
}
