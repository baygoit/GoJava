package ua.goit.alg;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * cLass for sorting integer numbers array in file.
 * Algorithm: read from source file data to array with bufSize length.
 * Sorting array with mergeSort. Writing array to temporary file.
 * Reading next data from source, sorting and merge with temporary file to second temporary file.
 * Finally, when last data is read and sorted, it merge it to source file. 
 */
public class Arrays {
    private final static int bufSize = 4;

    public static void mergeSort(File source) {
	int[] buffer = new int[bufSize];
	File tmpResult1 = new File("tmpResult1.txt");
	File tmpResult2 = new File("tmpResult2.txt");
	boolean isEndOfFile = false;
	boolean isAccessToTmpResult = false;
	try {
	    tmpResult1.createNewFile();
	    tmpResult2.createNewFile();
	    FileInputStream inputFile = new FileInputStream(source);
	    DataInputStream dis = new DataInputStream(inputFile);
	    while (dis.available() != 0) {
		buffer = readInt(buffer, dis);
		mergeSort(buffer, 0, buffer.length - 1);
		if (isAccessToTmpResult) {
		    switchTmpFilesAndMerge(buffer, tmpResult1, tmpResult2, source, dis);
		    isAccessToTmpResult = false;
		}
		else {
		    switchTmpFilesAndMerge(buffer, tmpResult2, tmpResult1, source, dis);
		    isAccessToTmpResult = true;
		}
	    }
	    dis.close();
	    inputFile.close();
	} catch (Exception e) {
	    throw new RuntimeException("Something wrong with file.");
	} finally {
	    tmpResult1.delete();
	    tmpResult2.delete();
	}
    }

    //Read data from file to buffer array
    private static int[] readInt(int[] buffer, DataInputStream dis) 
	    throws IOException {
	for (int i = 0; i < buffer.length; i++) {
	    if (dis.available() <= 0) {
		int[] newLengthBuffer = new int[i];
		System.arraycopy(buffer, 0, newLengthBuffer, 0, i);
		buffer = newLengthBuffer;
		break;
	    }
	    buffer[i] = dis.readInt();
	}
	return buffer;
    }

    // Switch input and output files
    private static void switchTmpFilesAndMerge(int[] buffer, File tmpResult1, 
	    File tmpResult2, File source, DataInputStream dis) throws IOException {
	boolean isEndOfFile = (dis.available() == 0);
	if (!isEndOfFile) {
	    mergeWithFile(buffer, tmpResult1, tmpResult2);
	} else {
	    mergeWithFile(buffer, tmpResult1, source);
	}
    }

    //Merge buffer array with temp file
    private static void mergeWithFile(int[] buffer, File tmpResult1, 
	    File tmpResult2) throws IOException {
	FileInputStream inputFile = new FileInputStream(tmpResult1);
	FileOutputStream outputFile = new FileOutputStream(tmpResult2);
	DataInputStream dis = new DataInputStream(inputFile);
	DataOutputStream dos = new DataOutputStream(outputFile);
	int arrayIndex = 0;
	long intNumberQty = tmpResult1.length()/4;
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
	dos.flush();
	dos.close();
	dis.close();
	outputFile.close();
	inputFile.close();
    }

    //Sorting array
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