package ua.com.goit.gojava7.salivon.dao;

import ua.com.goit.gojava7.salivon.beans.Faq;

public interface FaqDao {

    public void saveFaq(Faq faq);

    public String getContextFaq(int idProject);
}
