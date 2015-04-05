package ua.goit.alg;

import java.io.*;

public class FIleOperations {
    public static void createFileWithNumbers(File file, int quantity) throws IOException {
        DataOutputStream output = null;
        try {
            output = new DataOutputStream(new FileOutputStream(file));
            for (int i = quantity; i > 0; i--) {
                output.writeInt(i);
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

    public static String printFile(File file) throws IOException{
        DataInputStream input = null;
        StringBuilder builder = new StringBuilder();
        try {
            input = new DataInputStream(new FileInputStream(file));
            while (input.available() > 0) {
                builder.append(input.readInt() + '\n');
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                input.close();
            }
            return builder.toString();
        }
    }

    public static void writeIntoFile(File file, int[] numbers) throws IOException{
        DataOutputStream output = null;
        try {
            output = new DataOutputStream(new FileOutputStream(file));
            for(int i = 0; i < numbers.length; i++) {
                output.writeInt(numbers[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }
}
