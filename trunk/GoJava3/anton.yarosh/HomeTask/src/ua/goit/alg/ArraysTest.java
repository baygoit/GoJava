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

    //MergeSort of file testing
    @Test
    public void mergeSortTest() throws IOException {
	File file = new File("test8.txt");
	int[] expecteds = {2, 8, 1, 0, 3, 2, 5};
	int[] actuals = new int[expecteds.length];
	writeArray(expecteds, file);
	java.util.Arrays.sort(expecteds);
	Arrays.mergeSort(file);
	readArray(actuals, file);
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
    
    private void readArray(int[] actuals, File file) throws IOException {
	FileInputStream inputFile = new FileInputStream(file);
	DataInputStream dis = new DataInputStream(inputFile);
	int i = 0;
	while (dis.available() > 0) {
	    actuals[i] = dis.readInt();
	    i++;
	}
	dis.close();
	inputFile.close();
    }
}