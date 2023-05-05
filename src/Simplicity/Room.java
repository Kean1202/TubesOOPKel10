package Simplicity;

import java.util.ArrayList;

import Simplicity.Objects.*;


public class Room {
    private final int roomLength=6 ; // semua panjang room 6
    private final int roomWidth=6 ; // semua lebar room 6
    private String roomName;
    private Room atas;
    private Room bawah;
    private Room kiri;
    private Room kanan;
    private ArrayList<Furniture> listFurniture = new ArrayList<>();
    private boolean[][] roomGrid = new boolean[roomLength][roomWidth];

    public Room(String roomName){
        this.roomName=roomName;
        atas = null;
        bawah = null;
        kiri = null;
        kanan = null;
        listFurniture = new ArrayList<Furniture>();
        for (int i = 0; i < roomLength; i++) {
            for (int j = 0; j < roomWidth; j++) {
                roomGrid[i][j] = false;
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
                if (!roomGrid[i][j]) {
                    System.out.println("Cannot place furniture, area is not vacant");
                    return false;
                }
            }
        }
    
        // Place the furniture
        for (int i = position.getX(); i < position.getX() + furnitureLength; i++) {
            for (int j = position.getY(); j < position.getY() + furnitureWidth; j++) {
                roomGrid[i][j] = false;
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
    
    // public void displayFurniture() {
    //     if (listFurniture.isEmpty()) {
    //         System.out.println("It seems like you don't have any furniture yet");
    //         return;
    //     }
    //     System.out.println("Furniture List: ");  
    //     for (Furniture furniture : listFurniture) {
    //         Point furnitureLoc = new Point(furniture.getFurnitureLocation().getX(),furniture.getFurnitureLocation().getY());
    //         furniture.setFurnitureLocation(furnitureLoc);
    //             System.out.println(furniture.getType() + " at position (" + furniture.getFurnitureLocation().getX() + "," +
    //             furniture.getFurnitureLocation().getY() + ")");
    //     }
    // }

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
    public ArrayList<Furniture> getFurniture(){
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


    //method
    public void placeFurniture(Point point, Furniture furniture){
        if (canPlaceFurniture(point, furniture)) {
            // Tandai seluruh sel yang ditempati dengan True
            for (int i = point.getX(); i < point.getX() + furniture.getLength(); i++) {
                for (int j = point.getY(); j < point.getY() + furniture.getWidth(); j++) {
                    roomGrid[i][j] = true;
                }
            }
            // Set posisi Furniture
            listFurniture.add(furniture);
            furniture.setLocation(point);
        } else {
            System.out.println("Furniture can't be placed.");
        }
    }


    public boolean canPlaceFurniture(Point point, Furniture furniture){
        // Periksa apakah ukuran furniture cukup di ruangan
        if (point.getX() + furniture.getLength() > roomLength || point.getY() + furniture.getWidth() > roomWidth) {
            return false;
        }

        // Periksa apakah sel yang akan ditempati furniture kosong
        for (int i = point.getX(); i < point.getX() + furniture.getLength(); i++) {
            for (int j = point.getY(); j <point.getY() + furniture.getWidth(); j++) {
                if (roomGrid[i][j]) {
                    return false;
                }
            }
        }

        return true; // Aman untuk diletakkan
    }

}

