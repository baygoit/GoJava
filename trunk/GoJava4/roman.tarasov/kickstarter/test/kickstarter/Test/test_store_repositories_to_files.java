package kickstarter.Test;

import static org.junit.Assert.*;
import kickstarter.repository.facade.FileRepositoryDriver;
import kickstarter.repository.facade.MemoryRepository;
import kickstarter.repository.facade.RepositoryException;
import kickstarter.repository.facade.iRepository;

import org.junit.Test;

public class test_store_repositories_to_files {
	public static final String PATH = "src/kickstarter/resources/csv_repository/";

	@Test
	public void test() {
		MemoryRepository mRepository=new MemoryRepository();
		FileRepositoryDriver driver = new FileRepositoryDriver();
		iRepository imemory=mRepository;
		iRepository idriver=driver;
	
		idriver.setAllRepositories(imemory.getAllRepositories());
		try {
			driver.createFileSystemRepository();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
