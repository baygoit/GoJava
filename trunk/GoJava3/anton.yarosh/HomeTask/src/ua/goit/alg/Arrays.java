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
    private static int bufSize = 10000;

    public static void mergeSort(File source) {
	int[] buffer = new int[bufSize];
	File tmpResult1 = new File("tmpResult1.txt");
	File tmpResult2 = new File("tmpResult2.txt");
	boolean isEndOfFile = false;
	boolean isAccessToTmpResult1 = false;
	try {
	    tmpResult1.createNewFile();
	    tmpResult2.createNewFile();
	    FileInputStream inputFile = new FileInputStream(source);
	    DataInputStream dis = new DataInputStream(inputFile);
	    while (dis.available() != 0) {
		bufSize = readInt(buffer, dis);
		mergeSort(buffer, 0, bufSize - 1);
		isAccessToTmpResult1 = switchTmpFilesAndMerge(buffer, tmpResult1, 
			tmpResult2, source, isAccessToTmpResult1);
	    }
	    dis.close();
	    inputFile.close();
	} catch (Exception e) {
	    throw new RuntimeException("Something went wrong. Please, check the file.");
	} finally {
	    tmpResult1.delete();
	    tmpResult2.delete();
	}
    }

    //Read data from file to buffer array
    private static int readInt(int[] buffer, DataInputStream dis) throws IOException {
	for (int i = 0; i < buffer.length; i++) {
	    if (dis.available() <= 0) {
		return i;
	    }
	    buffer[i] = dis.readInt();
	}
	return buffer.length;
    }

    // Switch input and output files
    private static boolean switchTmpFilesAndMerge(int[] buffer, File tmpResult1, 
	    File tmpResult2, File source, boolean isAccessToTmpResult1) throws IOException {
	boolean isEndOfFile = (buffer.length != bufSize);
	if (isAccessToTmpResult1) { 
	    if (!isEndOfFile) {
		mergeWithFile(buffer, tmpResult1, tmpResult2);
	    } else {
		mergeWithFile(buffer, tmpResult1, source);
	    }
	    return false;
	} else {
	    if (!isEndOfFile) {
		mergeWithFile(buffer, tmpResult2, tmpResult1);
	    } else {
		mergeWithFile(buffer, tmpResult2, source);
	    }
	    return true;
	}
    }

    //Merge buffer array with temp file
    private static void mergeWithFile(int[] buffer, File tmpResult1, 
	    File tmpResult2) throws IOException {
	FileInputStream inputFile = new FileInputStream(tmpResult1);
	FileOutputStream outputFile = new FileOutputStream(tmpResult2);
	DataInputStream dis = new DataInputStream(inputFile);
	DataOutputStream dos = new DataOutputStream(outputFile);
	int i = 0;
	boolean isLess = false;
	int numFromFile = (dis.available() != 0)? dis.readInt() : 0;
	while (i != bufSize || dis.available() != 0) {
	    if (isLess) {
		numFromFile = dis.readInt();
	    }

	    if (i != bufSize) {
		if (dis.available() != 0 && isLess == false) {
		    if (buffer[i] > numFromFile) {
			dos.writeInt(numFromFile);
			if (dis.available() != 0) {
			    isLess = true;
			} else {
			    isLess = false;
			}
		    } else {
			dos.writeInt(buffer[i]);
			i++;
			isLess = false;
		    }
		} else {
		    dos.writeInt(buffer[i]);
		    i++;
		    isLess = false;
		}
	    } else {
		dos.writeInt(numFromFile);
		isLess = true;
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