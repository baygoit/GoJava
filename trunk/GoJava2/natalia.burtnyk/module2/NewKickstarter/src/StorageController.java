import java.util.List;

public class StorageController {
	
	private DataStorage dataStorage;
	
	public StorageController() {
		dataStorage = new DataStorage();	
	}
	
	public String getRandomQuoteToView() {
		return dataStorage.getRundomQuote();
	}

	public List<Сategory> getListCategories() {
		return dataStorage.getCategoriesList();
	}

	public List<Project> getSpecificProjects(Сategory category) {
		return dataStorage.getSpecificProject(category);
	}
}