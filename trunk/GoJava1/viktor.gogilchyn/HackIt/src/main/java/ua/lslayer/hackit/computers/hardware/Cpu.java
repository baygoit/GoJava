package ua.lslayer.hackit.computers.hardware;

public class Cpu implements Hardware {
	private int id;
	private String manufacturer = "ACME Corp.";
	private String name = "";
	private int power = 0;

	public Cpu() {
		// TODO Auto-generated constructor stub
	}
	
	public Cpu(int id, String name, int power) {
		super();
		this.id = id;
		this.name = name;
		this.power = power;
	}

	@Override
	public String toString() {
		//TODO Make diff for MHz, GHz
		return name + ", " +power+" MHz";
	}

	@Override
	public String getManufacturer() {
		return this.manufacturer;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
	

}
