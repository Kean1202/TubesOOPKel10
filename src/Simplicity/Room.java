package Simplicity;

public class Room {
    private int roomWidth=6 ;
    private int roomLength=6 ;
    private String roomName;

    public Room(String name, int width, int length) {
        this.roomName = name;
        this.roomWidth = width;
        this.roomLength = length;
    }

    //getter
    public String getName(){
        return roomName;
    }
    public int getRoomWidth() {
        return roomWidth;
    }
    public int getRoomLength() {
        return roomLength;
    }

    //setter
    public void setName(String roomName){
        this.roomName = roomName;
    }
    public void setRoomWidth(int roomWidth) {
        this.roomWidth = roomWidth;
    }
    public void setRoomLength(int roomLength) {
        this.roomLength = roomLength;
    }

}
