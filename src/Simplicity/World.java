package Simplicity;

import java.util.*;

public class World {
	private int worldLength;
	private int worldWidth;
    private List<House> worldHouses; //ini kalau nama class untuk house = House, kalau ga, diganti aja yaaaa sama bawah2nya punten
	
	//Attribute untuk menghitung singleton instance
	private static World instance;
	private WorldTime worldTime;

	//Konstruktor
	private World(int length, int width, List<House> houses, WorldTime worldTime){
		this.worldLength = length;
		this.worldWidth = width;
		this.worldHouses = houses;
		this.worldTime = worldTime;

	}

	// Method setter getter
	/**
	 * @return
	 */

	public static World getInstance() {
        if (instance == null) {
            instance = new World(64,64, new ArrayList<House>(), new WorldTime());
        }
        return instance;
    }
	
	public int getworldWidth(){
		return worldWidth;
	}

	public int getworldLength(){
		return worldLength;
	}

	public List<House> getworldHouses(){
		return new ArrayList<>(worldHouses);

	}

	public WorldTime getWorldTime(){
		return worldTime;
	}

    public void setworldWidth(int width) {
        this.worldWidth = width;
    }

    public void setworldLength(int length) {
        this.worldLength = length;
    }

    public void addworldHouse(House house) {
        this.worldHouses.add(house);
    }
}
