package com.gojava.launch;

import com.gojava.model.CoffeePlacesMap;
import com.gojava.model.Place;
import com.gojava.user.Client;
import com.gojava.user.Owner;
import com.gojava.user.User;

public class UserTransactionManager {

	private CoffeePlacesMap map;
	
	public UserTransactionManager(CoffeePlacesMap map) {
		this.map = map;
	}
	
	class CoffeePlacesMapForUser extends CoffeePlacesMap {
		private CoffeePlacesMap map;
		
		public CoffeePlacesMapForUser(CoffeePlacesMap map) {
			this.map = map;
		}
		
		@Override
		public void add(Place place) {
			// do nothing
		}
		
		@Override
		public void displayCoffePlaceOnMap() {
			map.displayCoffePlaceOnMap();
		} 
		
	}
	
	public CoffeePlacesMap getApi(User user) {
		if (user instanceof Owner) {
			return map; 
		} else if (user instanceof Client) {
			return new CoffeePlacesMapForUser(map);
		} else {
			return null;
		}
	}

}
