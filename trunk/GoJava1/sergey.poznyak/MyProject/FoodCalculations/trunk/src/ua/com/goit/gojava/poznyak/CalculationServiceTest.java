package ua.com.goit.gojava.poznyak;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

public class CalculationServiceTest {

	@Test
	public void testCalculateWeights() {
		Map<Foodstuff, Integer> listWeights = CalculationService.calculateWeights();
		assertNotNull(listWeights);
		assertEquals(3, listWeights.size());
	}

}