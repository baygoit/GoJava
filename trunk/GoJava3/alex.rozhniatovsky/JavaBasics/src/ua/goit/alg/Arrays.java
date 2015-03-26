package ua.goit.alg;

import java.io.*;
import java.util.Random;

public class Arrays {

    public static void createFileWithNumbers(File file, int quantity) throws IOException{
        DataOutputStream output = null;
        try {
            output = new DataOutputStream(new FileOutputStream(file));
            Random number = new Random();
            for (int i = 0; i < quantity; i++) {
                output.writeInt(number.nextInt());
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (output != null) {
                output.close();
            }
        }
    }

    public static int divideFileWithBuffer(File file, int bufferSize) throws IOException{
        DataInputStream input = null;
        DataOutputStream output = null;
        int [] buffer = new int[bufferSize];
        int countOfBuffer = 0;
        int quantityOfTempFile = 0;
        try {
            input = new DataInputStream(new FileInputStream(file));
            while (countOfBuffer < bufferSize && input.available() > 0) {
                buffer[countOfBuffer] = input.readInt();
                countOfBuffer++;
                if (countOfBuffer == bufferSize) {
                    java.util.Arrays.sort(buffer);
                    output = new DataOutputStream(new FileOutputStream(new File(quantityOfTempFile + ".txt")));
                    quantityOfTempFile++;
                    for (int i = 0; i < bufferSize; i++) {
                        output.writeInt(buffer[i]);
                    }
                    countOfBuffer = 0;
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            if (output != null) {
                output.close();
            }
            if (input != null) {
                input.close();
            }
            return quantityOfTempFile;
        }
    }

    public static void printFile(File file) throws IOException{
        DataInputStream input = null;
        try {
            input = new DataInputStream(new FileInputStream(file));
            while (input.available() > 0) {
                System.out.println(input.readInt());
                }

            }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            if (input != null) {
                input.close();
            }
        }
    }

    public static void main(String[] args) {
        try {
            createFileWithNumbers(new File("source.txt"), 1000);
            int quantityOfTempFile = divideFileWithBuffer(new File("source.txt"), 128);
            for (int i = 0; i < quantityOfTempFile; i++) {
                printFile(new File (i + ".txt"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
