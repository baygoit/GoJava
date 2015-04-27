package anagrams;

class TestAnagrams {

	public static void main(String[] args) {

		String inputString = " мама мыла раму ";
		String[] arrayWords = inputString.split(" ");

		for (String index : arrayWords) {
			System.out.print(doAnagram(index) + " ");
		}
	}

	static String doAnagram(String input) {
		char[] inpBuff = input.toCharArray();
		char[] destBuff = new char[inpBuff.length];

		for (int index = 0; index < inpBuff.length; index++) {
			destBuff[inpBuff.length - index - 1] = inpBuff[index];
		}
		return new String(destBuff);
	}

}