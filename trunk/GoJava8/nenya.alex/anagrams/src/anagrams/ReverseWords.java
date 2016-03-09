package anagrams;

public class ReverseWords {

	public String reverseWords(String str) {
		StringBuilder resultBuilder = new StringBuilder();
		if (str == null) {
			throw new NullPointerException();
		}
		if (str.isEmpty()) {
			return "";
		}
		StringBuilder sb;
		String separator = "";
		String[] strArr = str.split(" ");
		for (int i = 0; i < strArr.length; i++) {
			sb = new StringBuilder(strArr[i]);
			resultBuilder.append(separator).append(sb.reverse());
			separator = " ";
		}

		return resultBuilder.toString();
	}
}
