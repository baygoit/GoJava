package ua.com.goit.gojava.poznyak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Day bean.
 * 
 * This bean implements the day image.
 * 
 * @version 0.1 11 Feb 2015
 * @author Sergey Poznyak
 */
public class Day {
	
	private List<Eating> eatingList = new ArrayList<Eating>();

	public boolean add(Eating e) {
		return eatingList.add(e);
	}

	public Eating get(int index) {
		return eatingList.get(index);
	}

	public Eating remove(int index) {
		return eatingList.remove(index);
	}
	
	/**
	 * Calculates foodstuff weights for one day.
	 * 
	 * @return Map of required foodstuffs and their weights
	 * @throws FoodCalculationsBLException
	 */
	public Map<Foodstuff, Integer> calculateWeights() throws FoodCalculationsBLException {
		try {
			Map<Foodstuff, Integer> result = new HashMap<Foodstuff, Integer>();
			for (Eating eating : eatingList) {
				Map<Foodstuff, Integer> eatingWeights = eating.calculateWeights();
				for (Foodstuff key : eatingWeights.keySet()) {
					if (result.containsKey(key)) {
						result.put(key, result.get(key) + eatingWeights.get(key));
					} else {
						result.put(key, eatingWeights.get(key));
					}
				}
			}
			return result;
		} catch (Exception e) {
			throw new FoodCalculationsBLException(e);
		}
	}

}
