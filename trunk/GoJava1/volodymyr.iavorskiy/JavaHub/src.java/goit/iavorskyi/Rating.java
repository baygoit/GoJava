package goit.iavorskyi;

import java.util.LinkedList;
import java.util.List;

public class Rating {

	private int rating = 0;
	private List<Integer> marks = new LinkedList<Integer>();

	public void deleteRating() {
		rating = 0;
		marks.clear();
	}

	public int getRating() {
		return rating;
	}

	public void addRating(int yourMark) {
		marks.add(yourMark);
		for (int i : marks) {
			rating += i;
		}
		rating /= marks.size();
	}
	
	public List<Integer> getMarks() {
		return marks;
	}

}
