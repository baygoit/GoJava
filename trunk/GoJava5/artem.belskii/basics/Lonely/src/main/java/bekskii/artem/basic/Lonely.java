package bekskii.artem.basic;

import java.util.HashSet;
import java.util.Set;

public class Lonely {
	public Set<Integer> findLonely(int[] data){
	    Set<Integer> uniques = new HashSet<Integer>();
	    Set<Integer> dups = new HashSet<Integer>();
	    //Integer [] data = new Integer []{2, 3, 2, 4, 3, 7, 2, 3, 4, 4};
	    for (Integer a : data){
	      if (!uniques.add(a)){
	        dups.add(a);
	      }
	    }
	    uniques.removeAll(dups);
	    return uniques;
	}

}
