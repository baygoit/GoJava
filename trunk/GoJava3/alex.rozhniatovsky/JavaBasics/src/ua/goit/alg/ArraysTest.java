package ua.goit.alg;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class ArraysTest {
    private static File source = new File("source");
    private static File result = new File("result");

    @Test
    public void divideFileWithBuffer() {
        long expectResult = source.length();
        long actualResult =  result.length();
        Assert.assertEquals(expectResult, actualResult);
    }

}