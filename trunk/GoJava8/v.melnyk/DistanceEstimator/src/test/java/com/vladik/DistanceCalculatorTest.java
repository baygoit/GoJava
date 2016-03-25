package com.vladik;

import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class DistanceCalculatorTest {

   private static DistanceCalculator distanceCalculator;
    @BeforeClass
    public static void setUp() throws Exception {
        List<Integer> list= new ArrayList<>();
        distanceCalculator = new DistanceCalculator(list);
    }
    @Test
    public void testDuplicateFirstMin() {
        List<Integer> array = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5);
        distanceCalculator.setListOfInputs(array);
        List<Integer> resultList = Arrays.asList(1);
        Assert.assertThat(distanceCalculator.findDistanceBetweenTwoMinimumInputs(), is(resultList));
    }
    @Test
    public void testDuplicateSecondtMin() {
        List<Integer> array = Arrays.asList(1, 2, 2, 2, 3, 3, 4, 4, 5, 5);
        distanceCalculator.setListOfInputs(array);
        List<Integer> resultList = Arrays.asList(1,2,3);
        Assert.assertThat(distanceCalculator.findDistanceBetweenTwoMinimumInputs(), is(resultList));
    }


}
