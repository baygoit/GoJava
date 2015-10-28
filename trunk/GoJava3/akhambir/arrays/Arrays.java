package ua.goit.alg;

import java.io.*;
import java.util.LinkedList;
import java.util.List;



public class Arrays {

    public static File file = new File("D:\\bigdata.txt");
    public static int mergeCounter = 1;
    public static List<String> fileNames = new LinkedList<String>();
    public static DataOutputStream writer;
    public static File firstTemporaryFile;
    public static File secondTemporaryFile;

    public static void main(String[] args) throws Exception {

        split(fileNames, file);

        mergeSort(fileNames);

    }

    public static void split (List<String> fileNames, File file) throws Exception {

        int maxMemory = 32768;
        int[] buffer = new int[maxMemory];

        int indexOfParts = 0;

        try(DataInputStream firstReader = new DataInputStream(new FileInputStream(file))) {

            while (firstReader.available() > 0) {

                try (DataOutputStream writer = getWriter(indexOfParts)) {

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
                }
                fileNames = addFileName(fileNames, indexOfParts);

                indexOfParts++;
            }
        }
        if ((fileNames.size() % 2) != 0) {
            File extraFile = temporaryFiles(fileNames, indexOfParts, 1);
            fileNames = addFileName(fileNames, indexOfParts);
        }
    }

    public static void mergeSort(List<String> fileNames) throws Exception {

        List <String> newFileNames = new LinkedList<String>();

        do {

            int indexOfBigParts = 0;
            int firstIndexForList = 0;
            int secondIndexForList = 1;
            int firstSingleInt = 0;
            int secondSingleInt = 0;

            while (firstIndexForList < fileNames.size()) {

                String firstFileNameSet = fileNames.get(firstIndexForList);
                String secondFileNameSet = fileNames.get(secondIndexForList);

                try (DataInputStream firstReader = new DataInputStream(new FileInputStream(firstFileNameSet));
                     DataInputStream secondReader = new DataInputStream(new FileInputStream(secondFileNameSet));
                     DataOutputStream writer = getWriter(indexOfBigParts, mergeCounter)) {

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
                }
                firstTemporaryFile = temporaryFiles(fileNames, firstIndexForList);
                secondTemporaryFile = temporaryFiles(fileNames, secondIndexForList);

                newFileNames = addFileName(newFileNames, indexOfBigParts, mergeCounter);

                firstIndexForList += 2;
                secondIndexForList += 2;

                indexOfBigParts++;
            }

            mergeCounter++;

            fileNames = new LinkedList<String>();
            fileNames.addAll(newFileNames);
            newFileNames.clear();

        } while (fileNames.size() > 1);
    }

    public static DataOutputStream getWriter(int indexOfParts, int ... mergeCounter) throws Exception{
        if (mergeCounter.length == 0) {
            writer = new DataOutputStream(new FileOutputStream("D:\\newDataPart" + indexOfParts + ".txt"));
        } else {
            writer = new DataOutputStream(new FileOutputStream("D:\\" + mergeCounter[0] + "thNewDataPart" + indexOfParts + ".txt"));
        }
        return writer;
    }

    public static List<String> addFileName(List<String> fileNames, int indexOfParts, int ... mergeCounter) {
        if (mergeCounter.length == 0) {
            fileNames.add("D:\\\\newDataPart" + indexOfParts + ".txt");
        } else {
            fileNames.add("D:\\\\" + mergeCounter[0] + "thNewDataPart" + indexOfParts + ".txt");
        }
        return fileNames;
    }

    public static File temporaryFiles(List<String> fileNames, int index, int ... extraFileIndicator) throws Exception {
        File temporaryFile;
        if (extraFileIndicator.length == 0) {
            temporaryFile = new File(fileNames.get(index));
            temporaryFile.deleteOnExit();
        } else {
            temporaryFile = new File("D:\\\\newDataPart" + index + ".txt");
            temporaryFile.createNewFile();
        }
        return temporaryFile;
    }
}
