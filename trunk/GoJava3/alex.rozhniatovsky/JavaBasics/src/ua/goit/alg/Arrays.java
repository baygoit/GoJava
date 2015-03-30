package ua.goit.alg;

import java.io.*;

import static ua.goit.alg.FIleOperations.createFileWithNumbers;
import static ua.goit.alg.FIleOperations.printFile;

public class Arrays {
    private static final String TEMP_PATH = "C:\\Users\\roznalex\\IdeaProjects\\GoJava3\\alex.rozhniatovsky\\JavaBasics\\temp\\";
    private static final String TEMP_RES_PATH = "C:\\Users\\roznalex\\IdeaProjects\\GoJava3\\alex.rozhniatovsky\\JavaBasics\\tempRes\\";
    private static final int BUFFER_SIZE = 3;

    private static int divideFileWithBuffer(File file, int bufferSize) throws IOException{
        DataInputStream input = null;
        DataOutputStream output = null;
        int[] buffer = new int[bufferSize];
        int countOfBuffer = 0;
        int quantityOfTempFile = 0;
        try {
            input = new DataInputStream(new FileInputStream(file));
            while (countOfBuffer < bufferSize && input.available() > 0) {
                buffer[countOfBuffer] = input.readInt();
                countOfBuffer++;
                if (countOfBuffer == bufferSize) {
                    java.util.Arrays.sort(buffer);
                    output = new DataOutputStream(new FileOutputStream(new File(TEMP_PATH + quantityOfTempFile)));
                    quantityOfTempFile++;
                    for (int i = 0; i < bufferSize; i++) {
                        output.writeInt(buffer[i]);
                    }
                    java.util.Arrays.fill(buffer, 0);
                    countOfBuffer = 0;
                    output.close();
                }
            }
            if (countOfBuffer != bufferSize) {
                int[] copyOfBuffer = java.util.Arrays.copyOfRange(buffer, 0, countOfBuffer);
                java.util.Arrays.sort(copyOfBuffer);
                output = new DataOutputStream(new FileOutputStream(new File(TEMP_PATH + quantityOfTempFile)));
                quantityOfTempFile++;
                for (int i = 0; i < copyOfBuffer.length; i++) {
                    output.writeInt(copyOfBuffer[i]);
                }
                java.util.Arrays.fill(buffer, 0);
                output.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                output.close();
            }
            if (input != null) {
                input.close();
            }
        }
        return quantityOfTempFile;
    }

    private static void deleteAllTempFiles(int quantityOfTempFile ) {
        for (int i = 0; i <= quantityOfTempFile; i++) {
            new File(TEMP_PATH + i).delete();
            if (i == 0 || (i == quantityOfTempFile)){
                continue;
            }
            new File(TEMP_RES_PATH + i).delete();
        }
    }

    private static void createFileFromTempFiles(int quantityOfTempFile) throws IOException{
        File first = new File(TEMP_PATH + 0);
        File second = new File(TEMP_PATH + 1);
        File result = new File(TEMP_RES_PATH + 1);
        mergeTwoFiles(first, second, result);

        for (int i = 1; i < quantityOfTempFile - 1; i++) {
            first = new File(TEMP_RES_PATH + i);
            second = new File(TEMP_PATH + (i + 1));
            if (i == quantityOfTempFile - 2) {
                result = new File("result");
            } else {
                result = new File(TEMP_RES_PATH + (i + 1));
            }
            mergeTwoFiles(first, second, result);
        }
        deleteAllTempFiles(quantityOfTempFile);
    }

    private static void mergeTwoFiles(File firstFile, File secondFile, File result) throws IOException{
        DataInputStream firstInput = null;
        DataInputStream secondInput = null;
        DataOutputStream output = null;
        try {
            firstInput = new DataInputStream(new FileInputStream(firstFile));
            secondInput = new DataInputStream(new FileInputStream(secondFile));
            output = new DataOutputStream(new FileOutputStream(result));
            int first = 0;
            int second = 0;
            if (firstInput.available() > 0) {
                first = firstInput.readInt();
            }
            if (secondInput.available() > 0) {
                second = secondInput.readInt();
            }

            while (firstInput.available() > 0 && secondInput.available() > 0) {
                if (first < second) {
                    output.writeInt(first);
                    first = firstInput.readInt();
                }else {
                    output.writeInt(second);
                    second = secondInput.readInt();
                }
            }

            while (firstInput.available() > 0) {
                output.writeInt(firstInput.readInt());
            }

            while (secondInput.available() > 0) {
                output.writeInt(secondInput.readInt());
            }

        } catch (FileNotFoundException e)  {
            e.printStackTrace();
        } finally {
            if (output != null) {
                output.close();
            }
            if (firstInput != null) {
                firstInput.close();
            }
            if (secondInput != null) {
                secondInput.close();
            }
        }
    }

    public static void mergeSort(File source) throws IOException{
        int quantityOfTempFile = divideFileWithBuffer(source, BUFFER_SIZE);
        createFileFromTempFiles(quantityOfTempFile);
    }

    public static void main(String[] args) {
        try {
            File source = new File("source");
            File result = new File("result");

            createFileWithNumbers(source, 7);
            mergeSort(source);
            printFile(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

