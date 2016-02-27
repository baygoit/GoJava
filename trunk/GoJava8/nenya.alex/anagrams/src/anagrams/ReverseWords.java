package anagrams;

public class ReverseWords {
	
	public String reverseWords(String str) throws EmptyStringException {
		StringBuilder resultBuilder = new StringBuilder();
		if (str != null) {
			if (!str.isEmpty()) {
				StringBuilder sb;
				String separator = "";
				String[] strArr = str.split(" ");
				for (int i = 0; i < strArr.length; i++) {
					sb = new StringBuilder(strArr[i]);
					resultBuilder.append(separator).append(sb.reverse());
					separator = " ";
				}
			} else {
				throw new EmptyStringException();
			}
		} else {
			throw new NullPointerException();
		}
		return resultBuilder.toString();
	}
}
