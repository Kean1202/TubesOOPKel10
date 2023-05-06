package Simplicity;

import java.util.*;

import Simplicity.Objects.*;


public class Room {
    private final int roomLength=6 ; // semua panjang room 6
    private final int roomWidth=6 ; // semua lebar room 6
    private String roomName;
    private Room up;
    private Room down;
    private Room left;
    private Room right;
    private ArrayList<Furniture> listFurniture = new ArrayList<>();
    private boolean[][] roomGrid = new boolean[roomLength][roomWidth];

    public Room(String name){
        this.roomName = name;
        this.listFurniture = new ArrayList<>();
        this.roomGrid = new boolean[roomWidth][roomLength];
        up = null;
        down = null;
        left = null;
        right = null;
    }
    

    //method
//    public boolean pasangBarang(Furniture furniture, Point position, Sim mySim) {
//        int furnitureLength = furniture.getLength();
//        int furnitureWidth = furniture.getWidth();
//
//        if (!mySim.simInventory.checkContains(furniture.getType())) {
//            System.out.println("Cannot place furniture, item not found in inventory");
//            return false;
//        }
//
//        // Check if the furniture fits inside the room
//        if (position.getX() + furnitureLength > roomLength ||
//                position.getY() + furnitureWidth > roomWidth) {
//            System.out.println("Furniture does not fit inside the room");
//            return false;
//        }
//
//        // Check if the area is vacant
//        for (int i = position.getX(); i < position.getX() + furnitureLength; i++) {
//            for (int j = position.getY(); j < position.getY() + furnitureWidth; j++) {
//                if (!roomGrid[i][j]) {
//                    System.out.println("Cannot place furniture, area is not vacant");
//                    return false;
//                }
//            }
//        }
//
//        // Place the furniture
//        for (int i = position.getX(); i < position.getX() + furnitureLength; i++) {
//            for (int j = position.getY(); j < position.getY() + furnitureWidth; j++) {
//                roomGrid[i][j] = false;
//            }
//        }
//
//        listFurniture.add(furniture);
//        mySim.simInventory.decreaseInventory(furniture, 1);
//        return true;
//    }

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
            System.out.println(furniture.getType());
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
    public Room getUp(){
        return this.up;
    }
    public Room getDown(){
        return this.down;
    }
    public Room getLeft(){
        return this.left;
    }
    public Room getRight(){
        return this.right;
    }
    public ArrayList<Furniture> getFurniture(){
        return this.listFurniture;
    }

    //setter
    public void setRoomName(String roomName){
        this.roomName = roomName;
    }
    public void setUp(Room room){
        this.up=room;
    }
    public void setDown(Room room){
        this.down=room;
    }
    public void setLeft(Room room){
        this.left=room;
    }
    public void setRight(Room room){
        this.right=room;
    }
    public void setListObjek(ArrayList<Furniture> listFurniture) {
        this.listFurniture = listFurniture;
    }


    //method
    public boolean placeFurniture(Point point, Furniture furniture){
        if (canPlaceFurniture(point, furniture)) {
            // sel yg ditempatin = true
            for (int i = point.getX(); i < point.getX() + furniture.getLength(); i++) {
                for (int j = point.getY(); j < point.getY() + furniture.getWidth(); j++) {
                    roomGrid[i][j] = true;
                }
            }
            listFurniture.add(furniture);
            furniture.setLocation(point);
            return true;
        } else {
            System.out.println("Furniture can't be placed.");
            return false;
        }
    }


    public boolean canPlaceFurniture(Point point, Furniture furniture){
        // Check furnitur cukup di ruangan
        if (point.getX() + furniture.getLength() > roomLength || point.getY() + furniture.getWidth() > roomWidth) {
            return false;
        }

        // cek sel kosong
        for (int i = point.getX(); i < point.getX() + furniture.getLength(); i++) {
            for (int j = point.getY(); j <point.getY() + furniture.getWidth(); j++) {
                if (roomGrid[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

}

