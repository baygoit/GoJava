package gojava;

public class Anagram {
	
	public String run(String string){
		String result="";
		String[] data = string.split(" ");
		for(int i=0; i<data.length; i++){
			boolean upperCase=false;
			if(data[i].charAt(0)>64&&data[i].charAt(0)<91){
				upperCase=true;
			}
			String specials="";			
			String reversedWord="";
			for(int j = data[i].length()-1; j>-1; j--){
				int checker = data[i].charAt(j);
				if(checker<65||checker>122||(checker>90&&checker<97)){
					specials+=data[i].charAt(j);
				} else{
					if(reversedWord==""&&upperCase){
						String up = ""+data[i].charAt(j);
						reversedWord=up.toUpperCase();
					}else if(j ==0&&upperCase){
						String down = ""+data[i].charAt(j);
						reversedWord+=down.toLowerCase();
					}else{
						reversedWord+=data[i].charAt(j);
					}
				}
			}
			result+=reversedWord;
			result+=new StringBuffer(specials).reverse().toString(); ;
			if(i<data.length-1){
				result+=" ";
			}
		}
		
		return result;
	}
}
