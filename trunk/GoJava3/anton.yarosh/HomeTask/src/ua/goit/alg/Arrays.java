package ua.goit.alg;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * cLass for sorting integer numbers array in the file.
 * Algorithm: read from source file data to array with BUF_SIZE length.
 * Sorting array with mergeSort. Writing array to temporary file.
 * Reading next data from source, sorting and merge with temporary file to second temporary file.
 * Finally, when last data is read and sorted, it merge to source file. 
 */
public class Arrays {
    private final static int BUF_SIZE = 4;

    public static void mergeSort(File source) {
	int[] buffer = new int[BUF_SIZE];
	try {
	    runMergeSort(buffer, source);
	} catch (Exception e) {
	    throw new RuntimeException("Something wrong with file.", e);
	}
    }

    static void mergeSort(int bufSize, File source) {
	int[] buffer = new int[bufSize];
	try {
	    runMergeSort(buffer, source);
	} catch (Exception e) {
	    throw new RuntimeException("Something wrong with file.", e);
	}
    }

    private static void runMergeSort(int[] buffer, File source) throws IOException {
	File input1 = new File("tmpResult1.txt");
	File input2 = new File("tmpResult2.txt");
	File tmpInput;
	boolean isEndOfFile = false;
	FileInputStream inputFile = null;
	DataInputStream dis = null;
	try {
	    input1.createNewFile();
	    input2.createNewFile();
	    inputFile = new FileInputStream(source);
	    dis = new DataInputStream(inputFile);
	    while (dis.available() != 0) {
		buffer = readInt(buffer, dis);
		mergeSort(buffer, 0, buffer.length - 1);
		
		/* On each iteration swap input and output file */
		writeToFile(buffer, input1, input2, source, dis);
		tmpInput = input1;
		input1 = input2;
		input2 = tmpInput;
	    }
	    dis.close();
	    inputFile.close();
	} catch (Exception e) {
	    throw new RuntimeException("Something wrong with file.", e);
	} finally {
	    dis.close();
	    inputFile.close();
	    input1.delete();
	    input2.delete();
	}
    }

    /* Read data from file to buffer array */
    private static int[] readInt(int[] buffer, DataInputStream dis) 
	    throws IOException {
	for (int i = 0; i < buffer.length; i++) {
	    if (dis.available() <= 0) {
		buffer = java.util.Arrays.copyOf(buffer, i); 
		break;
	    }
	    buffer[i] = dis.readInt();
	}
	return buffer;
    }

    /* Switch output files from tmp to source*/
    private static void writeToFile(int[] buffer, File input, 
	    File output, File source, DataInputStream dis) throws IOException {
	boolean isEndOfFile = (dis.available() == 0);
	File writeTo =isEndOfFile ? source : output;
	mergeWithFile(buffer, input, writeTo);	
    }

    /* Merge buffer array with tmp file */
    private static void mergeWithFile(int[] buffer, File input, File output) 
	    throws IOException {
	FileInputStream inputFile = null;
	FileOutputStream outputFile = null;
	DataInputStream dis = null;
	DataOutputStream dos = null;
	try {
	    inputFile = new FileInputStream(input);
	    outputFile = new FileOutputStream(output);
	    dis = new DataInputStream(inputFile);
	    dos = new DataOutputStream(outputFile);
	    int arrayIndex = 0;
	    long intNumberQty = input.length() / 4;
	    int numFromFile = 0;
	    boolean lastNumFromFile = true;
	    while (arrayIndex != buffer.length || dis.available() != 0 
		    || intNumberQty != 0) {
		if (dis.available() == 0 && intNumberQty == 0) {
		    dos.writeInt(buffer[arrayIndex]);
		    arrayIndex++;
		    continue;
		}

		if (dis.available() != 0 && lastNumFromFile == true) {
		    numFromFile = dis.readInt();
		}

		if (arrayIndex == buffer.length || buffer[arrayIndex] > numFromFile) {
		    dos.writeInt(numFromFile);
		    intNumberQty--;
		    lastNumFromFile = true;
		} else {
		    dos.writeInt(buffer[arrayIndex]);
		    arrayIndex++;
		    lastNumFromFile = false;
		}
	    }
	} catch (Exception e) {
	    throw new RuntimeException("Something wrong with file.", e);
	} finally {
	    dos.flush();
	    dos.close();
	    dis.close();
	    outputFile.close();
	    inputFile.close();
	}

    }

    /* Sorting array */
    private static void mergeSort(int []m, int p, int r) {
	if (p < r) {
	    int q = (p + r) / 2;
	    mergeSort(m, p, q);
	    mergeSort(m, q + 1, r);
	    merge(m, p, q, r);
	}
    }

    private static void merge(int m[], int p, int q, int r) {
	int n1 = q - p + 1;
	int n2 = r - q;
	int left[] = new int[n1 + 1];
	int right[] = new int[n2 + 1];
	left[left.length - 1] = Integer.MAX_VALUE;
	right[right.length - 1] = Integer.MAX_VALUE;
	for (int i = 0; i < n1; i++) {
	    left[i] = m[p + i];
	}

	for (int i = 0; i < n2; i++) {
	    right[i] = m[q + i + 1];
	}

	int i = 0;
	int j = 0;
	for (int k = p; k <= r; k++) {
	    if (left[i] <= right[j]) {
		m[k] = left[i];
		i++;
	    } else {
		m[k] = right[j];
		j++;
	    }
	}
    }
}