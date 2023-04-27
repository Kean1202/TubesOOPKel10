package Simplicity;

import java.util.ArrayList;

import Simplicity.Objects.Furniture;

public class Room {
    private int roomLength=6 ;
    private int roomWidth=6 ;
    private String roomName;
    private Room atas;
    private Room bawah;
    private Room kiri;
    private Room kanan;
    private ArrayList<Furniture> listFurniture;
    private final boolean[][] vacantRoom = new boolean[roomLength][roomWidth];
    // private final Furniture[][] furnitureMatrix = new Furniture[roomLength][roomWidth];

    //default room
    public Room() {
        //ini nunggu pasangBarang()

        // pasangBarang(bed);
        // pasangBarang(stove);
        // pasangBarang(desk);
        // pasangBarang(clock);
    }

    public Room(String roomName){
        this.roomName=roomName;
        this.roomName = roomName;
        atas = null;
        bawah = null;
        kiri = null;
        kanan = null;
        listFurniture = new ArrayList<Furniture>();

        for (int i = 0; i < roomLength; i++) {
            for (int j = 0; j < roomWidth; j++) {
                vacantRoom[i][j] = true;
            }
        }
    }

    //method
    public boolean pasangBarang(Furniture furniture, Point position) {
        int furnitureLength = furniture.getLength();
        int furnitureWidth = furniture.getWidth();
    
        // Check if the furniture fits inside the room
        if (position.getX() + furnitureLength > roomLength ||
                position.getY() + furnitureWidth > roomWidth) {
            System.out.println("Furniture does not fit inside the room");
            return false;
        }
    
        // Check if the area is vacant
        for (int i = position.getX(); i < position.getX() + furnitureLength; i++) {
            for (int j = position.getY(); j < position.getY() + furnitureWidth; j++) {
                if (!vacantRoom[i][j]) {
                    System.out.println("Cannot place furniture, area is not vacant");
                    return false;
                }
            }
        }
    
        // Place the furniture
        for (int i = position.getX(); i < position.getX() + furnitureLength; i++) {
            for (int j = position.getY(); j < position.getY() + furnitureWidth; j++) {
                vacantRoom[i][j] = false;
            }
        }
        furniture.setPosition(position);
        listFurniture.add(furniture);
        return true;
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
    public Room getAtas(){
        return this.atas;
    }
    public Room getBawah(){
        return this.bawah;
    }
    public Room getKiri(){
        return this.kiri;
    }
    public Room getKanan(){
        return this.kanan;
    }
    public ArrayList<Furniture>getFurniture(){
        return this.listFurniture;
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
    public void setAtas(Room room){
        this.atas=room;
    }
    public void setBawah(Room room){
        this.bawah=room;
    }
    public void setKiri(Room room){
        this.kiri=room;
    }
    public void setKanan(Room room){
        this.kanan=room;
    }
    public void setListObjek(ArrayList<Furniture> listFurniture) {
        this.listFurniture = listFurniture;
    }

}
