package ua.com.goit.gojava7.salivon.dao.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.com.goit.gojava7.salivon.dao.PathFile;
import ua.com.goit.gojava7.salivon.dao.QuoteDao;

public class QuoteDaoFileImp implements QuoteDao {

    @Override
    public String getRandomQuote() {
        Random random = new Random();
        String quote = null;
        File file = new File(PathFile.QUOTE.getPath());

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            br.mark((int) file.length() + 1);
            int count = 0;
            while ((quote = br.readLine()) != null) {
                count++;
            }
            int number = (int) (random.nextDouble() * count);
            br.reset();
            while (true) {
                quote = br.readLine();
                if (number == 0) {
                    String[] arr = quote.split("[|]");
                    quote = arr[0] + "\n Autor:" + arr[1];
                    break;
                } else {
                    number--;
                }

            }

        } catch (IOException ex) {
            Logger.getLogger(QuoteDaoFileImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return quote;
    }

}
