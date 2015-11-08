package ua.goit.kyrychok.kickstarter.dao.memory;

import ua.goit.kyrychok.kickstarter.dao.FaqDao;
import ua.goit.kyrychok.kickstarter.model.Faq;

public class MemoryFaqDao implements FaqDao {
    private MemoryStorage storage;

    public MemoryFaqDao(MemoryStorage storage) {
        this.storage = storage;
    }

    @Override
    public void add(int projectId, Faq faq) {
        storage.addFaq(projectId, faq);
    }
}
