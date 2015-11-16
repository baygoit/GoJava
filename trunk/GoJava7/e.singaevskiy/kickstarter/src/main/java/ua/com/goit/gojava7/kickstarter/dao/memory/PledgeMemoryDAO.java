package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Pledge;
import ua.com.goit.gojava7.kickstarter.dao.PledgeStorage;

public class PledgeMemoryDAO extends MemoryDAO<Pledge> implements PledgeStorage{

    public PledgeMemoryDAO(List<Pledge> dataSource) {
        super(dataSource);
    }

}
