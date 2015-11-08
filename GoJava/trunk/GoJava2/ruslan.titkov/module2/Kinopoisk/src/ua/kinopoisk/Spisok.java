package ua.kinopoisk;

import java.util.ArrayList;

public class Spisok {

	ArrayList<Serial> spisok = new ArrayList<>();
	
	public void addToSpisok(){
		Serial barkingBad  = new Serial();
		barkingBad.title = "Теория Большого Взрыва";
		barkingBad.season =4;
		barkingBad.episode= 12;
		spisok.add(barkingBad);
	}
	
	public static void abc(Serial serial){
		System.out.println("Сериал:" + serial.title + " \n" + "Сезон:" + serial.season + " \n" + "Серия:" + serial.episode);
	}
}
