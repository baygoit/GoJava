package distance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadList {
	
	public List<Integer> readList() throws IOException {
		ReadConsole reader = new ReadConsole();
		List<Integer> list = new ArrayList<>();
		String str;

		while (!(str = reader.read()).isEmpty()) {
			if (isValid(str)) {
				list.add(Integer.parseInt(str));
				System.out.println(list);
			}

		}
		return list;
	}
	
	private boolean isValid(String str) {
		boolean b = false;
		try {
			Integer.parseInt(str);
			b = true;
		} catch (NumberFormatException e) {
			System.out.println("Wrong entering! Try again!");
		}
		return b;
	}

}
