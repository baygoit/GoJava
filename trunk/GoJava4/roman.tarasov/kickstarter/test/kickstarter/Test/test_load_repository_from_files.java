package kickstarter.Test;

import static org.junit.Assert.*;
import kickstarter.repository.facade.FileRepositoryDriver;
import kickstarter.repository.facade.MemoryRepository;
import kickstarter.repository.facade.RepositoryException;
import kickstarter.repository.facade.iRepository;
import kickstarter.repository.facade.entity.Project;
import kickstarter.repository.facade.entityRepositories.IDcontent;
import kickstarter.repository.facade.entityRepositories.IRepository;
import kickstarter.repository.facade.entityRepositories.Repository;

import org.junit.Test;

public class test_load_repository_from_files {

	@Test
	public void test() {
		MemoryRepository mRepository=new MemoryRepository();
		FileRepositoryDriver driver = new FileRepositoryDriver();
		iRepository imemory=mRepository;
		iRepository idriver=driver;
		IRepository<IDcontent>projects=new Repository<Project>();
		idriver.setAllRepositories(imemory.getAllRepositories());
		try {
			driver.loaderFilesToInMemoryRepository(projects,"REPOSITORY", "Projects","project");
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(projects.getList().get(0).getID());
	}

}
