package ua.lslayer.hackit.computers.hardware;

public class Ram {
	private int id;
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
	

}
