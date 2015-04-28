package division;


//program work incorrect !!!!!


//program work incorrect !!!!!



public class TestDivision {
	public static void main(String[] args) {
		int divident = 12;
		int divider = 42;
		doDivision(divident, divider);
	}

	public static void doDivision(int divident, int divider) {
		String[] list = new String[30];
		String result = "";
		String tab = "";
		System.out.println(divident + " / " + divider);
		System.out.println("  ");
		int counter;
		int corrDivident = 0;
		int first;
		String startLine;
		if ((divident - divider) < 0) {
			corrDivident = divident;
			result = "0.";
			corrDivident *= 10;
			while (corrDivident < divider) {

				result += "0";
				corrDivident *= 10;
			}

			System.out.println(corrDivident + " | " + divider);
			first = corrDivident - (corrDivident % divider);
			result += (corrDivident - corrDivident % divider) / divider;

			startLine = " " + first + "   ";
		} else {
			corrDivident = divident;
			System.out.println(corrDivident + " | " + divider);
			first = corrDivident - (corrDivident % divider);
			result += (corrDivident - corrDivident % divider) / divider;

			startLine = " " + first + "   ";
		}

		for (counter = 0; counter < 10; counter++) {
			tab += " ";
			list[counter * 3] = tab + "---";
			corrDivident = corrDivident - first;

			if (corrDivident < divider) {
				corrDivident *= 10;
			}
			list[counter * 3 + 1] = tab + corrDivident;
			first = corrDivident - (corrDivident % divider);
			list[counter * 3 + 2] = tab + first;
			result += (corrDivident - corrDivident % divider) / divider;
			if ((corrDivident % divider) == 0) {
				break;
			}
		}
		System.out.println(startLine + result);
		for (int index = 0; index < (counter); index++) {
			System.out.println(list[index * 3]);
			System.out.println(list[index * 3 + 1]);
			System.out.println(list[index * 3 + 2]);
		}

	}
}
