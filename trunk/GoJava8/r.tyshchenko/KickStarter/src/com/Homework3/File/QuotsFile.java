package com.Homework3.File;

import com.Homework3.GetQuotes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by roman on 12.03.16.
 */
public class QuotsFile {
    public void quotesWhisFile() {
        BufferedReader reader = null;
        String thisLine = null;
        ArrayList<String> quotesWhisFile = new ArrayList<String>();
        try {


            reader = new BufferedReader(new FileReader("src/com/sourses/quotes.txt"));
            while ((thisLine = reader.readLine()) != null) {
                quotesWhisFile.add(thisLine);
            }
            Random randomQuotes = new Random();
            String qot = quotesWhisFile.get(randomQuotes.nextInt(quotesWhisFile.size()));
            System.out.println(qot);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }

    }
}
