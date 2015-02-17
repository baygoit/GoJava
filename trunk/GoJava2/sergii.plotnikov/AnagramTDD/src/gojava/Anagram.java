package gojava;

public class Anagram {
	
	public String run(String string){
		String result="";
		String[] data = string.split(" ");
		for(int i=0; i<data.length; i++){
			char[] part = data[i].toCharArray();
			for(int j = part.length-1; j>-1; j--){
				result+=part[j];
			}
			if(i<data.length-1){
				result+=" ";
			}
		}
		
		return result;
	}
}
