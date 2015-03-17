
public class GoITSecond {
	public static String two(String[] args){
		StringBuilder a = new StringBuilder("");
		for(String word : args)
		{
			for(int i = word.toCharArray().length -1; i >= 0; i--)
				a.append(word.toCharArray()[i]);
			
			a.append(" ");
		}
		return a.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(two(args));

	}

}
