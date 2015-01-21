package accountant;

import java.util.ArrayList;

public class RecordList {
	
	static ArrayList<Record> list = new ArrayList<Record>();

	public static void addList() {
		list.add(createNewRecord());
		
	}

	private static Record createNewRecord() {
		Record rNew = new Record();
		rNew.setName();
		rNew.setPrice();
		return rNew;
	}

}
