package Simplicity;
import java.util.ArrayList;
import java.util.List;

public class House {
    private int[] location;
    private List<Room> roomList;

    public House(int x, int y) {
        this.location = new int[] {x, y};
        this.roomList = new ArrayList<>();
    }

    public String getRoomName(int index) {
        return this.roomList.get(index).getName();
    }

    public List<Room> getRoomList() {
        return this.roomList;
    }

    public void setRoomName(int index, String name) {
        this.roomList.get(index).setName(name);
    }
}
