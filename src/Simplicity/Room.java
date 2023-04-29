package Simplicity;

import java.util.ArrayList;

import Simplicity.*;
import Simplicity.Objects.*;

public class Room {
    private final int roomLength=6 ; // semua panjang room 6
    private final int roomWidth=6 ; // semua lebar room 6
    private String roomName;
    private Room atas;
    private Room bawah;
    private Room kiri;
    private Room kanan;
    private int[] roomLocation;
    private ArrayList<Furniture> listFurniture = new ArrayList<>();
    private boolean[][] vacantRoom = new boolean[roomLength][roomWidth];

    public Room(String roomName){
        this.roomName=roomName;
        listFurniture = new ArrayList<Furniture>();
        for (int i = 0; i < roomLength; i++) {
            for (int j = 0; j < roomWidth; j++) {
                vacantRoom[i][j] = true;
            }
        }
    }

    //default room
    public void defaultRoom() {
        setRoomName("default room");
        atas = null;
        bawah = null;
        kiri = null;
        kanan = null;
        Bed singleBed = new Bed("single bed", 100,4, 1);
        Toilet toilet = new Toilet("toilet", 10, 1, 1);
        Stove gasStove = new Stove("gas stove", 50, 2, 1);
        Clock clock = new Clock("clock", 10, 1, 1, 0);
        Desk desk = new Desk("desk", 50, 3, 3);

        pasangBarang(singleBed,new Point(0,0));
        pasangBarang(toilet,new Point(4,0));
        pasangBarang(gasStove,new Point(0,2));
        pasangBarang(clock,new Point(4,2));
        pasangBarang(desk,new Point(1, 3));
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
    public String getRoomName(){
        return roomName;
    }
    public int[] getRoomLocation() {
        return roomLocation;
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
    public void setRoomName(String roomName){
        this.roomName = roomName;
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
    public void setLocation(int[] roomLocation) {
        this.roomLocation = roomLocation;
    }
    public void setListObjek(ArrayList<Furniture> listFurniture) {
        this.listFurniture = listFurniture;
    }

}
