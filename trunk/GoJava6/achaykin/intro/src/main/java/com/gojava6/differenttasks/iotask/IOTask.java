package com.gojava6.differenttasks.iotask;

import java.io.*;

public class IOTask {
    private static String FILE_NAME = "file.txt";
    private static String TEXT = "This is a very important message.\n" +
            "Everybody should read books. \n" +
            "Theme song of the Matrix was very famous in 1973.";
    private static String TEXT_FOR_UPDATE = "This is text, that change the file, cap";

    public static void main(String[] args) {
        writeInFile(FILE_NAME, TEXT);

        String inputtedText = readFromFIle(FILE_NAME);
        System.out.println(inputtedText);

        updateFile(FILE_NAME, TEXT_FOR_UPDATE);


    }

    public static void writeInFile(String filename, String text) {

        File file = new File(filename);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file.getAbsoluteFile());
            try {
                pw.write(text);
            } finally {
                pw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFIle(String filename) {

        StringBuilder sb = new StringBuilder();
        File file = new File(filename);

        try {
            BufferedReader bf = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String s;
                while ((s = bf.readLine()) != null) {
                    sb.append(s);
//                    sb.append("/n");
                }
            } finally {
                if (bf != null) {
                    bf.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void updateFile(String filename, String text) {
        String s = readFromFIle(filename);
        StringBuilder sb = new StringBuilder(s);
        sb.append("\n");
        sb.append(text);
        writeInFile(filename, sb.toString());
    }
}
