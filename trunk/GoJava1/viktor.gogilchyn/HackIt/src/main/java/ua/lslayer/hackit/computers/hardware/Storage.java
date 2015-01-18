package ua.lslayer.hackit.computers.hardware;

public class Storage {
	private int id = 0;
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
		//TODO Same as ram, make diff for Mb, Gb, Tb
		return name + ", " + size + " MB";
	}

	public int getStorageSize() {
		// TODO Auto-generated method stub
		return this.size;
	}

}
