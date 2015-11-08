package com.sergiisavin.factory.sweet;

import com.sergiisavin.candy.Candy;
import com.sergiisavin.candy.sweet.ChocolateCandy;
import com.sergiisavin.candy.sweet.HoneyCandy;
import com.sergiisavin.candy.sweet.JellyCandy;
import com.sergiisavin.factory.CandyFactory;

public class SweetCandyFactory implements CandyFactory {

	@Override
	public Candy createCandy(String type) {
		Candy result = null;
		switch(type){
		case "H":
			result = new HoneyCandy();
			break;
		case "J":
			result = new JellyCandy();
			break;
		case "C":
			result = new ChocolateCandy();
			break;
		default:
			result = null;
		}
		
		return result;
	}

}
