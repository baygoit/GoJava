package ua.com.goit.belskii.artem;

public class Distance {
	
	public int findMin(int [] list){
		int min=Integer.MAX_VALUE;
		
		for (int i=0;i<list.length;i++){
			if (list[i]<min){
				min=list[i];
			}
		}
		
	return min;	
	}
	
	public int findMax(int [] list){
		int max=Integer.MIN_VALUE;
		for (int i=0;i<list.length;i++){
			if (list[i]>max){
				max=list[i];
			}
		}
		return max;
	}
	
	public int findPosition(int [] list, int value){
		int answer=-1;
		for (int i = 0; i<list.length;i++){
			if (value==list[i]){
				answer=i;
				break;
			}
		}
		return answer;
	}
	
	public int findDistance(int [] list){
		int min=this.findMin(list);
		int max=this.findMax(list);
		int minPosition=this.findPosition(list, min);
		int maxPosition=this.findPosition(list, max);
		
		return maxPosition-minPosition;
	}

}
