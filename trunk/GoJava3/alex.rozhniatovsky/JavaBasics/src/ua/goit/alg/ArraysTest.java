package ua.goit.alg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ArraysTest {
    private static File source = null;
    private static File result = null;
    private static  int numbersQuantity = 0;

    @Before
    public void init() {
            source = new File("source");
            result = new File("result");
    }

    @Test
    public void testLengthSourceResult() {
        try {
            numbersQuantity = 7;
            FIleOperations.createFileWithNumbers(source, numbersQuantity);
            Arrays.mergeSort(source);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long expectResult = source.length();
        long actualResult =  result.length();
        Assert.assertEquals(expectResult, actualResult);
    }

    @Test
    public void testWithBigQuantityOfTempFiles() {
        String expectResult = null;
        String actualResult =  null;
        StringBuilder builder = null;

        for (int i = 500; i > 0; i--) {
            builder.append(i + '\n');
        }
        try {
            numbersQuantity = 500;
            FIleOperations.createFileWithNumbers(source, numbersQuantity);
            Arrays.mergeSort(source);
            expectResult = FIleOperations.printFile(result);
            actualResult =  builder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(expectResult, actualResult);
    }
}