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

    @Test
    public void mergeSortFileSizeGreaterThanDoubleBufferTest() throws IOException {
	File file = new File("test8.txt");
	int[] expecteds = {2, 8, 1, 0, 45, 21, 40, 60, 50};
	writeArray(expecteds, file);
	java.util.Arrays.sort(expecteds);
	Arrays.mergeSort(file);
	int[] actuals = readArray(expecteds.length, file);
	assertArrayEquals(expecteds, actuals);	
    }
    
   // MergeSort of file testing
    @Test
    public void mergeSortFileSizeLessThanDoubleBufferTest() throws IOException {
	File file = new File("test8.txt");
	int[] expecteds = {25, 46, 54, 38, 6, 2, 1};
	writeArray(expecteds, file);
	java.util.Arrays.sort(expecteds);
	Arrays.mergeSort(file);
	int[] actuals = readArray(expecteds.length, file);
	assertArrayEquals(expecteds, actuals);	
    }
     
    @Test
    public void mergeSortFileSizeEqualDoubleBufferTest() throws IOException {
	File file = new File("test9.txt");
	int[] expecteds = {2, 8, 1, 0, 0, 5, 3, 1};
	writeArray(expecteds, file);
	java.util.Arrays.sort(expecteds);
	Arrays.mergeSort(file);
	int[] actuals = readArray(expecteds.length, file);
	assertArrayEquals(expecteds, actuals);	
    }
    
    private void writeArray(int[] source, File file) throws IOException {
	FileOutputStream outputFile = new FileOutputStream(file);
	DataOutputStream dos = new DataOutputStream(outputFile);
	for (int i : source) {
	    dos.writeInt(i);
	}
	dos.flush();
	dos.close();
    }
    
    private int[] readArray(int length, File file) throws IOException {
	int[] result = new int[length];
	FileInputStream inputFile = new FileInputStream(file);
	DataInputStream dis = new DataInputStream(inputFile);
	int i = 0;
	while (dis.available() > 0) {
	    result[i] = dis.readInt();
	    i++;
	}
	dis.close();
	inputFile.close();
	return result;
    }
}