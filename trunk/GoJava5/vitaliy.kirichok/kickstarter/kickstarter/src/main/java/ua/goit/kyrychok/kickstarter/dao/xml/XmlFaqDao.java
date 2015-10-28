package ua.goit.kyrychok.kickstarter.dao.xml;

import ua.goit.kyrychok.kickstarter.dao.FaqDao;
import ua.goit.kyrychok.kickstarter.model.Faq;

public class XmlFaqDao implements FaqDao {
    private XmlStorage storage;

    public XmlFaqDao(XmlStorage storage) {
        this.storage = storage;
    }

    @Override
    public void add(int projectId, Faq faq) {
        storage.addFaq(projectId, faq);
    }
}
