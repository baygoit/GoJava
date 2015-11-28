package ua.com.goit.gojava7.kickstarter.model.storage;

import ua.com.goit.gojava7.kickstarter.model.Quote;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileQuoteStorage implements QuoteStorage {
    private final String path;

    public FileQuoteStorage(String path) {
        this.path = path;
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Quote> getQuotes() {
        List<Quote> quotes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path)))
        {
            String line;
            int lineNumber = 0;
            String text = "";
            String author = "";
            while ((line = reader.readLine()) != null) {
                if (lineNumber % 3 == 0) {
                    text = line;
                } else if (lineNumber % 3 == 1) {
                    author = line;

                    quotes.add(new Quote(text, author));
                }

                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return quotes;
    }

    @Override
    public void add(Quote quote) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            String text = quote.getText();
            String author = quote.getAuthor();

            writer.write(text);
            writer.newLine();
            writer.write(author);
            writer.newLine();
            writer.newLine();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

}
