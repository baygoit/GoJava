
public enum WorldMap {
	Afghanistan, Albania, Algeria, Andorra, Angola, Antarctica, Argentina, Armenia, 
	Australia, Austria;
	
	public static String getCountry(int index){
		return WorldMap.values()[index].toString();
	}
	
	public static void showCountries(){
		int num = 1;
		for (WorldMap map : WorldMap.values()){
			System.out.println(num + "- " + map);
			num++;
		}
	}
}
