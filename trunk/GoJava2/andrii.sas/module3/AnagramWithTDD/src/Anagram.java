public class Anagram {
	public String getAnagram(String s){
		String result = "";
		int index = 1;
		String[] words = s.split(" ");
		for (String word : words){
			StringBuffer sentence = new StringBuffer(word);
			sentence.reverse();
			result += sentence.toString() + (index == words.length ? "" : " ");
			index++;
						
		}
		return result;
	}
}
