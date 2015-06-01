package kickstarter.repository.facade.entityRepositories;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExtendedByID<T extends IDcontent > extends ArrayList<T> implements List<T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7791418864434924061L;
	ArrayList<T> list;

	public int getID(Integer i) {
		T t=list.get((int) i);
		return t.getID();
	}
}
