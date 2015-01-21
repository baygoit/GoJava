package accountant;

import java.util.ArrayList;

public class RecordList {
	
	static ArrayList<Record> list = new ArrayList<Record>();

	public static void addList() {
		list.add(createNewRecord());
		
	}

	public static Record createNewRecord() {
		Record rNew = new Record();
		rNew.setName();
		rNew.setPrice();
		return rNew;
	}
	
	public static void output(){
		int sum=0;
		for(int j = 0; j < list.size(); j++){
		System.out.println(list.get(j).getName() + " - " + list.get(j).getPrice());
		}
	}

}
