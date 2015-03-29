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
    private static File source;
    private static File tmpResult1;
    private static File tmpResult2;
    private static File result;
    private static boolean semaphore = false;
    private static boolean endOfFile = false;

    public static void mergeSort(File file) {
	int[] buffer = new int[bufSize];
	source = file;
	tmpResult1 = new File("tmpResult1.txt");
	tmpResult2 = new File("tmpResult2.txt");
	try {
	    tmpResult1.createNewFile();
	    tmpResult2.createNewFile();
	    FileInputStream inputFile = new FileInputStream(file);
	    DataInputStream dis = new DataInputStream(inputFile);
	    while (dis.available() != 0) {
		if (semaphore) { 
		    result = tmpResult1;
		}
		else {
		    result = tmpResult2;
		}
		bufSize = readInt(buffer, dis);
		mergeSort(buffer, 0, bufSize - 1);
		mergeWithFile(buffer, result);
	    }
	    tmpResult1.delete();
	    tmpResult2.delete();
	}
	catch (Exception e) {
	    e.printStackTrace();
	}

    }

    //Read data from file to buffer array
    public static int readInt(int[] buffer, DataInputStream dis) throws IOException {
	for (int i = 0; i < buffer.length; i++) {
	    if (dis.available() <= 0) {
		endOfFile = true;
		return i;
	    }
	    buffer[i] = dis.readInt();
	}
	return buffer.length;
    }

    //Merge buffer array with temp file
    public static void mergeWithFile(int[] buffer, File tmpResult) throws IOException {
	FileInputStream inputFile = new FileInputStream(tmpResult);
	DataInputStream dis = new DataInputStream(inputFile);
	if (!endOfFile) {
	    if (semaphore) { 
		result = tmpResult2;
		semaphore = false;
	    }
	    else {
		result = tmpResult1;
		semaphore = true;
	    }
	}
	else {
	    result = source;
	}
	FileOutputStream output = new FileOutputStream(result);
	DataOutputStream dos = new DataOutputStream(output);
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
			}
			else {
			    isLess = false;
			}
		    }
		    else {
			dos.writeInt(buffer[i]);
			i++;
			isLess = false;
		    }
		}
		else {
		    dos.writeInt(buffer[i]);
		    i++;
		    isLess = false;
		}
	    }
	    else {
		dos.writeInt(numFromFile);
		isLess = true;
	    }
	}
	dos.flush();
	dos.close();
	dis.close();
    }

    //Sorting array
    public static void mergeSort(int []m, int p, int r) {
	if (p < r) {
	    int q = (p + r) / 2;
	    mergeSort(m, p, q);
	    mergeSort(m, q + 1, r);
	    merge(m, p, q, r);
	}
    }

    public static void merge(int m[], int p, int q, int r) {
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
	    }
	    else {
		m[k] = right[j];
		j++;
	    }
	}
    }
}