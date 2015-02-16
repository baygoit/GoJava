package utils;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ua.home.kickstarter.content.Project;

@SuppressWarnings("rawtypes")
public class JsonReaderAndWriterTest {
	private List<Project> pr1;
	private KickstarterJsonWriter kickstarterJsonWriter;

	private KickstarterJsonReader kickstarterJsonReader;

	@Before
	public void setUp() {
		pr1 = new ArrayList<Project>();
		pr1.add(new Project("FakeName1", "Fakedescription1", 34534, 34, "linksToVideo1"));
		pr1.add(new Project("FakeName2", "Fakedescription1", 23123, 345, "linksToVideo1"));
		pr1.add(new Project("FakeName3", "Fakedescription1", 34534, 67, "linksToVideo1"));

		kickstarterJsonWriter = new KickstarterJsonWriter();

		kickstarterJsonReader = new KickstarterJsonReader();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void shouldReturnSameList_whichYouSaveToHardDrive() {
		kickstarterJsonWriter.saveJsonToHardDrive(pr1, "JsonReaderAndWriterTest.json");

		List<Project> list = kickstarterJsonReader.getList(Project.class, "JsonReaderAndWriterTest.json");
		for (int index = 0; index < list.size(); index++) {
			assertEquals(pr1.get(index).getName(), list.get(index).getName());
			assertEquals(pr1.get(index).getFullInfo(), list.get(index).getFullInfo());
			assertEquals(pr1.get(index).getShortInfo(), list.get(index).getShortInfo());
		}
 
	}
}
