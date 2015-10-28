package ua.com.goit.gojava.lslayer.module1.project3;

public class WordReverserExample {

	public static void main(String[] args) {
		WordReverser wr = new WordReverser("lorem ipsum, dolor sit amet");
		System.out.println(wr.reverse());
		WordReverser wr2 = new WordReverser();
		System.out.println(wr2.reverse());
		WordReverser wr3 = new WordReverser();
		wr3.setOriginalPhrase("merol muspi rolod tis tema");
		System.out.println(wr3.reverse());
	}

}
