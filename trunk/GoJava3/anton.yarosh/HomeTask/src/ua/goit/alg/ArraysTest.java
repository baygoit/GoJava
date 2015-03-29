package ua.goit.alg;

import static org.junit.Assert.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class ArraysTest {

    //Reading int from file testing
    @Test
    public void readIntTest() throws IOException {
	FileInputStream inputFile = new FileInputStream("test4.txt");
	DataInputStream dis = new DataInputStream(inputFile);
	int[] expecteds = {6, 8, 1, 0, 3, 2, 5};
	int[] actuals = new int[expecteds.length];
	Arrays.readInt(actuals, dis);
	assertArrayEquals(expecteds, actuals);	
    }

    //MergeSort of file testing
    @Test
    public void mergeSortTest() throws IOException {
	int[] expecteds = {6, 8, 1, 0, 3, 2, 5};
	int[] actuals = new int[expecteds.length];
	File file = new File("test8.txt");
	FileOutputStream outputFile = new FileOutputStream(file);
	DataOutputStream dos = new DataOutputStream(outputFile);
	for (int i : expecteds) {
	    dos.writeInt(i);
	}
	dos.flush();
	dos.close();
	Arrays.mergeSort(file);
	java.util.Arrays.sort(expecteds);
	FileInputStream inputFile = new FileInputStream(file);
	DataInputStream dis = new DataInputStream(inputFile);
	Arrays.readInt(actuals, dis);
	assertArrayEquals(expecteds, actuals);	
    }
}
