package ua.goit.kyrychok.kickstarter.dao.xml;

import ua.goit.kyrychok.kickstarter.dao.ProjectDao;
import ua.goit.kyrychok.kickstarter.model.Project;

public class XmlProjectDao implements ProjectDao {
    private XmlStorage storage;

    public XmlProjectDao(XmlStorage storage) {
        this.storage = storage;
    }

    @Override
    public Project load(int id) {
        return storage.getProject(id);
    }

    @Override
    public void setBalance(int projectId, int amount) {
        storage.setProjectBalance(projectId, amount);
    }

    @Override
    public int getBalance(int projectId) {
        return storage.getProjectBalance(projectId);
    }
}
