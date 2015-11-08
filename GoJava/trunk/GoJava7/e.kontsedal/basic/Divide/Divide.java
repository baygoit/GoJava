import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Divide {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		int dividend = readingDividendFromConsole(reader);
		int divisor = readingDivisorFromConsole(reader);
		reader.close();
		String strRes = integerPartOfFraction(dividend, divisor);
		System.out.println(returnAnswerInConsole(dividend, divisor, strRes));
	}

	public static int readingDividendFromConsole(BufferedReader reader)
			throws IOException {
		while (true) {
			System.out.println("Enter dividend");
			try {
				int dividend = Integer.parseInt(reader.readLine());
				return dividend;
			}

			catch (NumberFormatException e) {
				System.out.println("Please enter the NUBMER!");
			}
		}
	}

	public static int readingDivisorFromConsole(BufferedReader reader)
			throws IOException {
		while (true) {
			System.out.println("Enter divisor");
			try {
				int divisor = Integer.parseInt(reader.readLine());
				if (divisor == 0)
					System.out.println("I'm too stupid to divide by 0");
				else
					return divisor;
			} catch (NumberFormatException e) {
				System.out.println("Please enter the NUBMER!");
			}
		}

	}

	public static String integerPartOfFraction(int dividend, int divisor) {
		String result;
		if (dividend < divisor) {
			result = "0,";
		} else {
			int integerPart = (dividend - ((dividend / divisor) * divisor));
			result = String.valueOf(integerPart);
			if (dividend % divisor != 0)
				result += ",";
		}
		return result;
	}

	public static String returnAnswerInConsole(int dividend, int divisor,
			String strRes) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		String result = "";
		String tab = "";
		int dividendInFraction = (dividend > divisor) ? (dividend - ((dividend / divisor) * divisor))
				: dividend;
		while (dividendInFraction != 0) {
			tab += " ";
			map.put(dividendInFraction, strRes.length());
			dividendInFraction *= 10;
			result += tab + "---\n" + tab + dividendInFraction + "\n" + tab
					+ dividendInFraction / divisor * divisor + "\n";
			if (dividendInFraction < divisor) {
				strRes += "0";
				continue;
			}
			int fraction = dividendInFraction / divisor;
			dividendInFraction = dividendInFraction % divisor;
			strRes += String.valueOf(fraction);
			if (map.containsKey(dividendInFraction)) {
				strRes = strRes.substring(0, map.get(dividendInFraction)) + "("
						+ strRes.substring(map.get(dividendInFraction)) + ")";
				break;
			}
		}
		strRes = dividend + " |" + divisor + "\n" + dividend / divisor
				* divisor + " |" + strRes + "\n" + result;

		return strRes;
	}
}
