package distance;

import java.io.IOException;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		FindDistance fd = new FindDistance();
		ReadList reader = new ReadList();

		System.out.println("Enter the numbers");
		List<Integer> list = null;
		try {
			list = reader.readList();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<Integer> distancesList = fd.findDistances(list);
		System.out.println("List of distances is " + distancesList);
	}

}
