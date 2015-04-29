package main;

public class Array2LowestElemDistance {

	public static void main(String[] args) {
		int [] arr = {2,45,34,12,45,12,32,52,102,49,100};
		//System.out.println("arr " + arr);
		System.out.println(findDistanceBetween2Lowest(arr));
	}
	
	static int findDistanceBetween2Lowest (int arr []){
		int distance=0;
		int length = arr.length;
		System.out.println("length " + length);
		if (length<=1) return -1;
		int lowest1 = arr[0];
		int lowIndex1 = 0;
		int lowest2 = Integer.MAX_VALUE;
		int lowIndex2 = 0;

		for (int i = 2; i<length; i++){
			if (lowest2 > arr[i]) {
				lowest2=arr[i];
				lowIndex2 = i;
			}
			if (lowest2 < lowest1) {
				//keep the lowest at lowest1
				int tmp = lowest1;
				lowest1 = lowest2;
				lowest2 = tmp;
				//swap indexes
				tmp = lowIndex1;
				lowIndex1 = lowIndex2;
				lowIndex2 = tmp;
			}
		}
		System.out.print("Массив: ");
		for(int  i = 0; i < arr.length; i++) {
			  System.out.print(arr[i] + "  ");
			}
		System.out.println("");
		System.out.print("Расстояние между наименьшими элеметами "+lowest2+" и "+lowest1+" = ");
		System.out.println("Индексы наименьших элементов "+lowIndex2+" и "+lowIndex1);
		distance = Math.abs(lowIndex1 - lowIndex2);
		return distance;
	}
	
	static int findDistanceBetweenAny2Lowest(int arr []){
		int distance=0;
		
		return distance;
	}
	

}
