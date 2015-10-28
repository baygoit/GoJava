package ua.goit.kyrychok.kickstarter.dao.memory;

import ua.goit.kyrychok.kickstarter.dao.ProjectDao;
import ua.goit.kyrychok.kickstarter.model.Project;

public class MemoryProjectDao implements ProjectDao {
    private MemoryStorage storage;

    public MemoryProjectDao(MemoryStorage storage) {
        this.storage = storage;
    }

    @Override
    public Project load(int id) {
        return storage.getProject(id);
    }

    @Override
    public void setBalance(int projectId, int amount) {
        load(projectId).setBalance(amount);
    }

    @Override
    public int getBalance(int projectId) {
        return load(projectId).getBalance();
    }
}
