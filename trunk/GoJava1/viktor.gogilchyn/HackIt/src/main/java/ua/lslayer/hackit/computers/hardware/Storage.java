package ua.lslayer.hackit.computers.hardware;

public class Storage implements Hardware {
	private int id = 0;
	private String manufacturer = "ACME Corp.";
	private String name = "";
	private int size = 0;

	public Storage(int id, String name, int size) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
	}

	@Override
	public String toString() {
		//TODO Make diff for Mb, Gb, Tb
		return name + ", " + size + " MB";
	}

	public int getStorageSize() {
		return this.size;
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
