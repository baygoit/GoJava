package ua.com.goit.gojava.poznyak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The schedule bean.
 * 
 * This bean implements the schedule image.
 * 
 * @version 0.1 11 Feb 2015
 * @author Sergey Poznyak
 */
public class Schedule {
	
	private Integer peopleNum;
	
	private List<Day> dayList = new ArrayList<Day>();

	public Integer getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(Integer peopleNum) {
		this.peopleNum = peopleNum;
	}

	public boolean add(Day e) {
		return dayList.add(e);
	}

	public Day get(int index) {
		return dayList.get(index);
	}

	public Day remove(int index) {
		return dayList.remove(index);
	}
	
	/**
	 * Calculates foodstuff weights for whole schedule.
	 * 
	 * @return Map of required foodstuffs and their weights
	 * @throws FoodCalculationsBLException
	 */
	public Map<Foodstuff, Integer> calculateWeights() throws FoodCalculationsBLException {
		try {
			Map<Foodstuff, Integer> result = new HashMap<Foodstuff, Integer>();
			for (Day day : dayList) {
				Map<Foodstuff, Integer> dayWeights = day.calculateWeights();
				for (Foodstuff key : dayWeights.keySet()) {
					if (result.containsKey(key)) {
						result.put(key, result.get(key) + dayWeights.get(key));
					} else {
						result.put(key, dayWeights.get(key));
					}
				}
			}
			return result;
		} catch (Exception e) {
			throw new FoodCalculationsBLException(e);
		}
	}

}
