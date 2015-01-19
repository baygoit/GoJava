package myprogect;

public class Route {
	Trip trip;
	public Route(Trip trip){
		this.trip = trip;
	}
	public void findRoute(){
		System.out.println(trip.getAdressFrom() + " " + trip.getAdressTo());
	}
}
