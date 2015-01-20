package myprogect;

public class PublicTransport {
	boolean nextTransport;
	Time time;
	
	public static void main(String[] args){
		Route route = new Route(new Trip());
		Time time = new Time(new Bus());
		route.trip.setAdressFrom("trabe");
		route.trip.setAdressTo("berwood");
		route.findRoute();
		time.findTime();
	}
	

}
