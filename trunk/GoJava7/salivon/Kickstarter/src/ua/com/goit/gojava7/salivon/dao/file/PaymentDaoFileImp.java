package ua.com.goit.gojava7.salivon.dao.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.com.goit.gojava7.salivon.beans.Payment;
import ua.com.goit.gojava7.salivon.dao.PathFile;
import ua.com.goit.gojava7.salivon.dao.PaymentDao;

public class PaymentDaoFileImp implements PaymentDao {

    @Override
    public void savePayment(Payment payment) {
        File file = new File(PathFile.PAYMENT.getPath());
        int idProject = payment.getIdProject();
        String namePayer = payment.getNamePayer();
        long numberCard = payment.getNumberCard();
        int total = payment.getTotal();
        try (BufferedWriter br = new BufferedWriter(new FileWriter(file, true))) {

            br.write(idProject + "|" + namePayer + "|" + numberCard + "|" + total + "\n");
        } catch (IOException ex) {
            Logger.getLogger(PaymentDaoFileImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getTotal(int idProject) {
        int total = 0;
        File file = new File(PathFile.PAYMENT.getPath());
        String line = null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while ((line = br.readLine()) != null) {
                String[] arr = line.split("[|]");
                int id = Integer.parseInt(arr[0].trim());
                int sum = Integer.parseInt(arr[3].trim());
                if (id == idProject) {
                    total += sum;

                }

            }

        } catch (IOException ex) {
            Logger.getLogger(PaymentDaoFileImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

}
