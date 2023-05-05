package Simplicity;

import java.util.ArrayList;
import java.util.Scanner;

import Simplicity.Objects.*;
import Simplicity.*;


public class Room {
    private final int roomLength=6 ; // semua panjang room 6
    private final int roomWidth=6 ; // semua lebar room 6
    private String roomName;
    private Room atas;
    private Room bawah;
    private Room kiri;
    private Room kanan;
    private ArrayList<Furniture> listFurniture = new ArrayList<>();
    private boolean[][] vacantRoom = new boolean[roomLength][roomWidth];
    private Menu menu;

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
    public void defaultRoom(Sim mySim) {
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

        pasangBarang(singleBed,new Point(0,0), mySim);
        pasangBarang(toilet,new Point(4,0), mySim);
        pasangBarang(gasStove,new Point(0,2), mySim);
        pasangBarang(clock,new Point(4,2), mySim);
        pasangBarang(desk,new Point(1, 3), mySim);
    }

    //method
    public boolean pasangBarang(Furniture furniture, Point position, Sim mySim) {
        int furnitureLength = furniture.getLength();
        int furnitureWidth = furniture.getWidth();

        if (!mySim.simInventory.checkContains(furniture.getType())) {
            System.out.println("Cannot place furniture, item not found in inventory");
            return false;
        }
    
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
        
        listFurniture.add(furniture);
        mySim.simInventory.decreaseInventory(furniture, 1);
        return true;
    }

    public void printRoom() {
        char[][] room = new char[roomLength][roomWidth];
        for (int i = 0; i < roomLength; i++) {
            for (int j = 0; j < roomWidth; j++) {
                room[i][j] = '.';
            }
        }
        for (Furniture furniture : listFurniture) {
            int furnitureLength = furniture.getLength();
            int furnitureWidth = furniture.getWidth();
            Point furnitureLoc = furniture.getFurnitureLocation();
            for (int i = furnitureLoc.getX(); i < furnitureLoc.getX() + furnitureLength; i++) {
                for (int j = furnitureLoc.getY(); j < furnitureLoc.getY() + furnitureWidth; j++) {
                    room[i][j] = 'F';
                }
            }
        }
        System.out.println("   | 1 2 3 4 5 6 |");
        System.out.println("---+-------------+");
        for (int i = 0; i < roomLength; i++) {
            System.out.print(" " + (i+1) + " |");
            for (int j = 0; j < roomWidth; j++) {
                System.out.print(" " + room[i][j]);
            }
            System.out.println(" |");
        }
        System.out.println("---+-------------+");
    }  
    
    public void displayFurniture() {
        if (listFurniture.isEmpty()) {
            System.out.println("It seems like you don't have any furniture yet");
            return;
        }
        System.out.println("Furniture List: ");  
        for (Furniture furniture : listFurniture) {
            Point furnitureLoc = new Point(furniture.getFurnitureLocation().getX(),furniture.getFurnitureLocation().getY());
            furniture.setFurnitureLocation(furnitureLoc);
                System.out.println(furniture.getType() + " at position (" + furniture.getFurnitureLocation().getX() + "," +
                furniture.getFurnitureLocation().getY() + ")");
        }
    }

    public void editRoom(Sim mysim){
        System.out.println("Pilih opsi yang diinginkan:");
        System.out.println("1. Beli barang baru");
        System.out.println("2. Pindah barang");
        Scanner scanner = new Scanner(System.in);
        String choice;
        System.out.print("Enter your choice: ");
        choice = scanner.nextLine();
         switch(choice) {
            case "1":
                System.out.println("Available items to purchase:");
                mysim.simBuyItem(null,itemName, roomLength);
                
         }
                


    }

    //getter
    public String getRoomName(){
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
    public void setListObjek(ArrayList<Furniture> listFurniture) {
        this.listFurniture = listFurniture;
    }

}
