package ua.com.run4life;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class PersonalPlan {
	private int distance;
	private Date date;
	private byte preferAmountOfTrainings;
	private String levelOfTraining;
	private String lastTime;
	private String perferTime;
	private LinkedList<Workout> workouts;
	
	public int getDistance() {
		return distance;
	}
	
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public byte getPreferAmountOfTrainings() {
		return preferAmountOfTrainings;
	}
	
	public void setPreferAmountOfTrainings(byte preferAmountOfTrainings) {
		this.preferAmountOfTrainings = preferAmountOfTrainings;
	}
	
	public String getLevelOfTraining() {
		return levelOfTraining;
	}
	
	public void setLevelOfTraining(String levelOfTraining) {
		this.levelOfTraining = levelOfTraining;
	}
	
	public String getLastTime() {
		return lastTime;
	}
	
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}
	
	public String getPerferTime() {
		return perferTime;
	}
	
	public void setPerferTime(String perferTime) {
		this.perferTime = perferTime;
	}
	
	public List<Workout> getWorkout() {
		return workouts;
	}
	
	public void addWorkout(Workout workout) {
		this.workouts.add(workout);
	}
	
}
