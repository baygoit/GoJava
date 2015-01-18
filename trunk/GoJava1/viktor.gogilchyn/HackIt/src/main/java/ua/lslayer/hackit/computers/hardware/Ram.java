package ua.lslayer.hackit.computers.hardware;

public class Ram implements Hardware {
	private int id;
	private String manufacturer = "ACME Corp.";
	private String name = "";
	private int size = 0;

	public Ram(int id, String name, int size) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
	}

	@Override
	public String toString() {
		//TODO make MB, GB, TB differentiation in output
		return name + ", " + size + " Mb";
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
