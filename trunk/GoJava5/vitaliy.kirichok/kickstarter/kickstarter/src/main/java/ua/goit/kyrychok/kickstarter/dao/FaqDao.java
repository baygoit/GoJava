package ua.goit.kyrychok.kickstarter.dao;

import ua.goit.kyrychok.kickstarter.model.Faq;

public interface FaqDao {

    void add(int projectId, Faq faq);
}
