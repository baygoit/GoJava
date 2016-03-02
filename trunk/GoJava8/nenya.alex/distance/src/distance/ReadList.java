package distance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadList {
	
	public List<Integer> readList() throws IOException {
		ReadConsole reader = new ReadConsole();
		List<Integer> list = new ArrayList<>();
		String str = reader.read();
		
			if (isValid(str)) {
				String[] array = str.split(" ");
				for(int i = 0; i < array.length; i++){
					list.add(Integer.parseInt(array[i]));
				}
			}
		return list;
	}
	
	private boolean isValid(String str) {
		boolean b = false;
		String[] array = str.split(" ");
		for(int i = 0; i < array.length; i++){
			try {
				Integer.parseInt(array[i]);
				b = true;
			} catch (NumberFormatException e) {
				System.out.println("Wrong entering! Try again!");
				break;
			}
		}
		
		return b;
	}

}
