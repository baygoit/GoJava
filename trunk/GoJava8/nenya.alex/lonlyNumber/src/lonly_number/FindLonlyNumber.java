package lonly_number;


public class FindLonlyNumber {

	public int findLonly(int[] mas){
		int item = 0;
		int count = 0;
		if (mas == null || mas.length == 0) {
			throw new NullPointerException();
		}else{
			for (int i = 0; i < mas.length; i++) {
				item = mas[i];
				for (int j = 0; j < mas.length; j++) {
					if (item == mas[j] && i != j) {
						break;
					}
					if(j ==  mas.length -1){
						count = j;
					}
				}
				if(count ==  mas.length -1){
					break;
				}
			}
		}
			
		return item;

		
	}
}
