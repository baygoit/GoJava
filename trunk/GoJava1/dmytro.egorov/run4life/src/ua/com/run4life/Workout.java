package ua.com.run4life;

import java.util.Date;

public class Workout {
	private String typeOfWorkout;
	private float distance;
	private float tempoSpeed;
	private Date dateOfWorkout;
	
	public String getTypeOfWorkout() {
		return typeOfWorkout;
	}
	
	public void setTypeOfWorkout(String typeOfWorkout) {
		this.typeOfWorkout = typeOfWorkout;
	}
	
	public float getDistance() {
		return distance;
	}
	
	public void setDistance(float distance) {
		this.distance = distance;
	}
	
	public float getTempoSpeed() {
		return tempoSpeed;
	}
	
	public void setTempoSpeed(float tempoSpeed) {
		this.tempoSpeed = tempoSpeed;
	}
	
	public Date getDateOfWorkout() {
		return dateOfWorkout;
	}
	
	public void setDateOfWorkout(Date dateOfWorkout) {
		this.dateOfWorkout = dateOfWorkout;
	}
	
}
