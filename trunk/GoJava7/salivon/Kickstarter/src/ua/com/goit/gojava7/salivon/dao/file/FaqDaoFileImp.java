package ua.com.goit.gojava7.salivon.dao.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.com.goit.gojava7.salivon.beans.Faq;
import ua.com.goit.gojava7.salivon.dao.FaqDao;
import ua.com.goit.gojava7.salivon.dao.PathFile;

public class FaqDaoFileImp implements FaqDao {

    @Override
    public void saveFaq(Faq faq) {
        File file = new File(PathFile.FAQ.getPath());
        int idProject = faq.getIdProject();
        String context = faq.getContext();
        try (BufferedWriter br = new BufferedWriter(new FileWriter(file, true))) {

            br.write(idProject + "|" + context + "\n");
        } catch (IOException ex) {
            Logger.getLogger(FaqDaoFileImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getContextFaq(int idProject) {
        String faq = "";
        File file = new File(PathFile.FAQ.getPath());
        String line = null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while ((line = br.readLine()) != null) {
                String[] arr = line.split("[|]");
                int id = Integer.parseInt(arr[0].trim());
                String context = arr[1].trim();
                if (id == idProject) {
                    faq += context + "\n";

                }

            }

        } catch (IOException ex) {
            Logger.getLogger(FaqDaoFileImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return faq;
    }

}
