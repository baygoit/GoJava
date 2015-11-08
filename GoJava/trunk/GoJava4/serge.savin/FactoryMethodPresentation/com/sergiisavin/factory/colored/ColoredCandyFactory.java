package com.sergiisavin.factory.colored;

import com.sergiisavin.candy.Candy;
import com.sergiisavin.candy.colored.BlueCandy;
import com.sergiisavin.candy.colored.GreenCandy;
import com.sergiisavin.candy.colored.RedCandy;
import com.sergiisavin.candy.sweet.ChocolateCandy;
import com.sergiisavin.candy.sweet.HoneyCandy;
import com.sergiisavin.candy.sweet.JellyCandy;
import com.sergiisavin.factory.CandyFactory;

public class ColoredCandyFactory implements CandyFactory {

	@Override
	public Candy createCandy(String type) {
		Candy result = null;
		switch(type){
		case "R":
			result = new RedCandy();
			break;
		case "G":
			result = new GreenCandy();
			break;
		case "B":
			result = new BlueCandy();
			break;
		default:
			result = null;
		}
		
		return result;
	}

}
