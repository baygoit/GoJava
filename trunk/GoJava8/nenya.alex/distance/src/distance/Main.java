package distance;

import java.io.IOException;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws IOException {
		FindDistance fd = new FindDistance();
		ReadList reader = new ReadList();

		System.out.println("Enter the numbers through the space");
		List<Integer> list = null;
			list = reader.readList();
		List<Integer> distancesList = fd.findDistances(list);
		System.out.println("List of distances is " + distancesList);
	}

}
