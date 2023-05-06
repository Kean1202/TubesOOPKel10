package Simplicity;
import Simplicity.Objects.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class House {
    private String name;
    private Point location;
    private List<Room> roomList;
    private int roomTotal;

    public House(int x, int y, String name) {
        this.location = new Point(x,y);
        this.roomList = new ArrayList<>();
        this.name = name;

        roomList.add(new Room("Bedroom"));

        Bed singleBed = new Bed("single bed", 100,4, 1);
        Toilet toilet = new Toilet("toilet", 10, 1, 1);
        Stove gasStove = new Stove("gas stove", 50, 2, 1);
        Clock clock = new Clock("clock", 10, 1, 1, 0);
        Desk desk = new Desk("desk", 50, 3, 3);

        getRoom("Bedroom").placeFurniture(new Point(0, 0), singleBed);
        getRoom("Bedroom").placeFurniture(new Point(0, 1), toilet);
        getRoom("Bedroom").placeFurniture(new Point(4, 0), gasStove);
        getRoom("Bedroom").placeFurniture(new Point(5, 1), clock);
        getRoom("Bedroom").placeFurniture(new Point(0, 3), desk);
    }

    public Room getRoom(String roomName){
        Room temp = null;
        for(Room room : roomList){
            if(room.getRoomName().equals(roomName)){
                temp = room;
            }
        }
        return temp;
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

    public void addRoom(Room room) {
        System.out.println("Where do you want to expand your room?");
        System.out.println("Options:");
        if (room.getUp() == null) {
            System.out.println("Up");
        }
        if (room.getDown() == null) {
            System.out.println("Down");
        }
        if (room.getLeft() == null) {
            System.out.println("Left");
        }
        if (room.getRight() == null) {
            System.out.println("Right");
        }

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String name;
        boolean valid = false;

        while (!valid) {
            if (input.toLowerCase().equals("up")) {
                if (room.getUp() == null) {
                    System.out.println("There is no room above this room!");
                    System.out.println("Please provide a name for this room:");
                    name = sc.nextLine();

                    while (!isNameValid(name)) {
                        System.out.println("This room name is already used! Please provide another name:");
                        name = sc.nextLine();
                    }

                    Room newRoom = new Room(name);
                    room.setUp(newRoom);
                    newRoom.setDown(room);
                    roomList.add(newRoom);
                } else {
                    System.out.println("Sorry, there is already a room above this one!");
                }
                valid = true;
            } else if (input.toLowerCase().equals("down")) {
                if (room.getDown() == null) {
                    System.out.println("Creating a new room below this room!");
                    System.out.println("Please provide a name for the new room:");
                    name = sc.nextLine();

                    while (!isNameValid(name)) {
                        System.out.println("This room name is already used! Please provide another name:");
                        name = sc.nextLine();
                    }

                    Room newRoom = new Room(name);
                    room.setDown(newRoom);
                    newRoom.setUp(room);
                    roomList.add(newRoom);
                } else {
                    System.out.println("Sorry, there is already a room below this one!");
                }
                valid = true;
            } else if (input.toLowerCase().equals("left")) {
                if (room.getLeft() == null) {
                    System.out.println("Creating a new room to the left of this room!");
                    System.out.println("Please provide a name for the new room:");
                    name = sc.nextLine();

                    while (!isNameValid(name)) {
                        System.out.println("This room name is already used! Please provide another name:");
                        name = sc.nextLine();
                    }

                    Room newRoom = new Room(name);
                    room.setLeft(newRoom);
                    newRoom.setRight(room);
                    roomList.add(newRoom);
                } else {
                    System.out.println("Sorry, there is already a room to the left of this one!");
                }
                valid = true;
            } else if (input.toLowerCase().equals("right")) {
                if (room.getRight() == null) {
                    System.out.println("Creating a new room to the right of this room!");
                    System.out.println("Please provide a name for the new room:");
                    name = sc.nextLine();

                    while (!isNameValid(name)) {
                        System.out.println("This room name is already used! Please provide another name:");
                        name = sc.nextLine();
                    }

                    boolean kanan = true;
                    Room newRoom = new Room(name);
                    room.setRight(newRoom);
                    newRoom.setLeft(room);
                    roomList.add(newRoom);
                } else {
                    System.out.println("Sorry, there is already a room to the right of this one!");
                }
                    valid = true;
            } else {
                    System.out.println("The option entered does not match the available options");
                    System.out.println("Please enter a valid option");
                    input = sc.nextLine();
            }
        }
    }

    public boolean isNameValid(String name) {
        Boolean valid = true;
        for (Room room : roomList) {
            if (room.getRoomName().toLowerCase().equals(name.toLowerCase())) {
                valid = false;
            }
        }
        return valid;
    }
}
