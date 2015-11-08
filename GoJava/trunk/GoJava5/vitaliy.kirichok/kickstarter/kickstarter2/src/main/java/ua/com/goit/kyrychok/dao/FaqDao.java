package ua.com.goit.kyrychok.dao;

import ua.com.goit.kyrychok.domain.Faq;

public interface FaqDao {

    void add(int projectId, Faq faq);
}
