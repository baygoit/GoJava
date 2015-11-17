package ua.com.goit.gojava7.kickstarter.dao.file;

import ua.com.goit.gojava7.kickstarter.beans.Pledge;
import ua.com.goit.gojava7.kickstarter.dao.PledgeStorage;

public class PledgeFileDAO extends FileDAO<Pledge> implements PledgeStorage {

    public PledgeFileDAO() {
        super(Pledge.class);
    }

    public PledgeFileDAO(String pathToFile) {
        super(Pledge.class, pathToFile);
    }

}
