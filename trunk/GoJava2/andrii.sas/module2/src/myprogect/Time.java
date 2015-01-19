package myprogect;

public class Time {
	Transport transport;
	public Time(Transport transport){
		this.transport = transport;
	}
	public void findTime(){
		transport.getSpeed();
		System.out.println("It will be there in time");
	}
}
