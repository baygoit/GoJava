package bekskii.artem.basic;

import java.util.HashSet;
import java.util.Set;

public class Lonely {
	
	public Set<Integer> findLonely(int[] data) {
		Set<Integer> uniques = new HashSet<Integer>();
		Set<Integer> dups = new HashSet<Integer>();
		for (Integer a : data) {
			if (!uniques.add(a)) {
				dups.add(a);
			}
		}
		uniques.removeAll(dups);
		return uniques;
	}

}
