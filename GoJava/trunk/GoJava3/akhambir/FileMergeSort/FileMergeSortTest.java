package ua.goit.alg;

import org.junit.Test;
import java.io.*;
import java.util.*;
import static org.junit.Assert.*;

public class FileMergeSortTest {
  public static File smallFile = new File("D:\\smallF.txt");

  @Test
  public void givenBuffer32mbWhenMethodSplitMakeSmallPartsThenSmallPartsEqualBuffer() throws Exception {
	FileMergeSort.split(FileMergeSort.fileNames, FileMergeSort.file);
	int actualResult = 32768;
	long expectedResult = new File(FileMergeSort.fileNames.get(0)).length();
	assertEquals(expectedResult / 4, actualResult);
  }

  @Test
  public void givenSmallFileWhenActualResultWillBeSortedAutomaticallyAndExpectedResultWillBeSortedByFileMergeSortThenArraysWillBeEquals() throws Exception {
	List<String> fileNames = new LinkedList<String>();

	int [] actualResult = new int[10];

	FileMergeSort.split(fileNames, smallFile);
	fileNames = FileMergeSort.mergeSort(fileNames);

	  int[] expectedResult = new int[10];

	  try (DataInputStream firstDio = new DataInputStream(new FileInputStream(smallFile));
		 DataInputStream secondDio = new DataInputStream(new FileInputStream(fileNames.get(0)))) {

		int i = 0;
		while (firstDio.available() > 0) {
		  actualResult[i] = firstDio.readInt();
		  i++;
	  }
		int j = 0;
		while (secondDio.available() > 0) {
		  expectedResult[j] = secondDio.readInt();
		  j++;
	  }
	}

	Arrays.sort(actualResult);
	assertArrayEquals(expectedResult, actualResult);
  }

}