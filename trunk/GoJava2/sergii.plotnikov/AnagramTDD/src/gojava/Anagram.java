package gojava;

public class Anagram {
	
	public String run(String string){
		String result="";
		String[] data = string.split(" ");
		for(int i=0; i<data.length; i++){
			String specials="";			
			for(int j = data[i].length()-1; j>-1; j--){
				int checker = data[i].charAt(j);
				if(checker<65||checker>122||(checker>90&&checker<97)){
					specials+=data[i].charAt(j);
				} else{
					result+=data[i].charAt(j);
				}
			}
			result+=new StringBuffer(specials).reverse().toString(); ;
			if(i<data.length-1){
				result+=" ";
			}
		}
		
		return result;
	}
}
