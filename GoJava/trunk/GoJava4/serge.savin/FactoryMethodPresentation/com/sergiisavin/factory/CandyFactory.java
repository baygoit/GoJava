package com.sergiisavin.factory;

import com.sergiisavin.candy.Candy;

public interface CandyFactory {
	Candy createCandy(String type);
}
