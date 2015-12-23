package com.gojava6.additionalTasks;

import java.io.*;
import java.util.*;

public class Parser {

    //private String filePath = "C:\\Users\\Maryna\\Desktop\\ParseByManagerID.txt";

    public String readFromFile(String filePath) {
        BufferedReader reader = null;
        String[] str = null;
        StringBuilder stringBuilder = new StringBuilder();
        {
            try {
                reader = new BufferedReader(new FileReader(new File(filePath)));

                String string;
                while ((string = reader.readLine()) != null) {
                    /*str = string.split(" ");
                    stringBuilder.append(Arrays.toString(str));*/

                    stringBuilder.append(string + " ");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();

        /*assert string != null;
        String[] result = string.split(" ");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Arrays.toString(result));*/

    }

    public void sortData(String fileData) {

        String[] stringsArr = fileData.split("\\s+");

        int id;
        for (int i = 0; i < stringsArr.length; i++) {
            if (i%4 == 0){
                id = i;
            }
        }

        /*Map dataManagerID = new TreeMap<>();
        while (stringsArr != null) {
            dataManagerID.put();
        }*/

        ArrayList list = new ArrayList();
        list.add(stringsArr);

        System.out.println(list);

        /*StringBuilder builder = new StringBuilder();
        builder.append(fileData.split("\\s+"));*/

            /*    ArrayList list = new ArrayList();
        list.add(fileData);

        System.out.println(list);*/
    }

    public static void main(String[] args) {
        Parser parser = new Parser();
        String file;
        file = parser.readFromFile("C:\\Users\\Maryna\\Desktop\\ParseByManagerID.txt");

        parser.sortData(file);

        System.out.println(file);

        //System.out.println(parser.readFromFile());
        /*String[] result = result1.split(" ");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Arrays.toString(result));*/

    }
}

