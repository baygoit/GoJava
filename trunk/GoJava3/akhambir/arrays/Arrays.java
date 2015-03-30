package ua.goit.alg;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Arrays {

    public static File file = new File("D:\\bigdata.txt");
    public static int mergeCounter = 1;
    public static int maxMemory = 32768;
    public static int[] buffer = new int[maxMemory];
    public static List<String> fileNames = new LinkedList<String>();
    public static DataInputStream firstReader;
    public static DataInputStream secondReader;
    public static DataOutputStream writer;

    public static void main(String[] args) throws Exception {

        separator(fileNames, file, buffer);

        mergeSort(fileNames);

    }

    public static List separator (List<String> fileNames, File file, int[] buffer) throws Exception {

        int indexOfParts = 0;

        firstReader = new DataInputStream(new FileInputStream(file));

        while (firstReader.available() > 0) {
           writer = new DataOutputStream(new FileOutputStream("D:\\newDataPart" + indexOfParts + ".txt"));

            int i = 0;
            while (firstReader.available() > 0 && i < buffer.length) {
                int singleInt = firstReader.readInt();
                buffer[i] = singleInt;
                i++;
            }

            int[] sorted = MergeSort.sort(buffer, 0, buffer.length);

            for (int j = 0; j < sorted.length; j++) {
                writer.writeInt(sorted[j]);
            }

            fileNames.add("D:\\\\newDataPart" + indexOfParts + ".txt");
            writer.close();
            indexOfParts++;
        }

        if ((fileNames.size() % 2) != 0) {
            File extraFile = new File("D:\\\\newDataPart" + indexOfParts + ".txt");
            extraFile.createNewFile();
            fileNames.add("D:\\\\newDataPart" + indexOfParts + ".txt");
        }

        return fileNames;
    }

    public static void mergeSort(List<String> fileNames) throws Exception {

        List <String> newFileNames = new LinkedList<String>();

        int indexOfBigParts = 0;
        int firstIndexForList = 0;
        int secondIndexForList = 1;
        int firstSingleInt = 0;
        int secondSingleInt = 0;


        while (firstIndexForList < fileNames.size()) {

            firstReader = new DataInputStream(new FileInputStream(fileNames.get(firstIndexForList)));
            secondReader = new DataInputStream(new FileInputStream(fileNames.get(secondIndexForList)));

            writer = new DataOutputStream(new FileOutputStream("D:\\" + mergeCounter + "thNewDataPart" + indexOfBigParts + ".txt"));

            firstSingleInt = firstReader.readInt();
            if (secondReader.available() > 0) {
                secondSingleInt = secondReader.readInt();
            }

            while (firstReader.available() > 0 || secondReader.available() > 0) {
                if (firstReader.available() > 0 && secondReader.available() > 0) {
                    if (firstSingleInt < secondSingleInt) {
                        writer.writeInt(firstSingleInt);
                        firstSingleInt = firstReader.readInt();
                    } else {
                        writer.writeInt(secondSingleInt);
                        secondSingleInt = secondReader.readInt();
                    }
                } else if (firstReader.available() > 0 && secondReader.available() == 0) {
                    writer.writeInt(firstSingleInt);
                    firstSingleInt = firstReader.readInt();
                } else {
                    writer.writeInt(secondSingleInt);
                    secondSingleInt = secondReader.readInt();
                }
            }

            File firstTemporaryFile = new File(fileNames.get(firstIndexForList));
            firstTemporaryFile.deleteOnExit();
            firstReader.close();

            File secondTemporaryFile = new File(fileNames.get(secondIndexForList));
            secondTemporaryFile.deleteOnExit();
            secondReader.close();

            newFileNames.add("D:\\\\" + mergeCounter + "thNewDataPart" + indexOfBigParts + ".txt");

            firstIndexForList += 2;
            secondIndexForList += 2;

            indexOfBigParts++;
            writer.close();
        }

        if (newFileNames.size() > 1) {
            mergeCounter++;
            mergeSort(newFileNames);
        }
    }
}
