package Simplicity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime; // Format : yyyy-MM-ddTHH:mm:ss.SSS

public class World {
	private int worldLength;
	private int worldWidth;
    private List<House> worldHouses; //ini kalau nama class untuk house = House, kalau ga, diganti aja yaaaa sama bawah2nya punten
	
	//Attribute untuk menghitung singleton instance
	private static World instance;

    //Attribute untuk waktu
    private int[] timeSeries; // untuk mengeset 24 jam
	private LocalDateTime currentTime; //untuk menyimpan waktu dengan format : yyyy-MM-ddTHH:mm:ss.SSS
	private String currentDay; //untuk menyimpan nama hari

	//Konstruktor
	private World(int length, int width, List<String> houses){
		this.worldLength = length;
		this.worldWidth = width;
		this.worldHouses = new ArrayList<House>(houses);
		this.timeSeries = new int[24];
		this.currentTime = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0); //start day with 00:00:00.00
		this.currentDay = currentTime.getDayOfWeek().name();
		// Membuat task untuk melakukan method pergantian waktu (tick) tiap detik

	}

	// Method setter getter
	/**
	 * @return
	 */

	public static World getInstance() {
        if (instance == null) {
            instance = new World(100,200, new ArrayList<House>());
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

	public LocalDateTime getCurrentTime(){
		return currentTime;
	}

	public String getCurrentDay(){
		return currentDay;
	}

    public void setworldWidth(int width) {
        this.worldWidth = width;
    }

    public void setworldLength(int length) {
        this.worldLength = length;
    }

    public void addworldHouse(String house) {
        this.worldHouses.add(house);
    }

	public void setTimeSeries(int[] timeSeries){
		this.timeSeries = timeSeries;
	}

	public void decreaseTime(int seconds){
		currentTime = currentTime.minusSeconds(seconds);
		if (currentTime.getHour() == 0 && currentTime.getMinute() ==0 && currentTime.getSecond()==0){
			Arrays.fill(timeSeries,0);
			currentDay = currentTime.plusDays(1).getDayOfWeek().name();
		}
		
	}

	public void changeDay(){
		currentDay = currentTime.plusDays(1).getDayOfWeek().name();
	}
}
