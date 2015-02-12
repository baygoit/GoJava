package mainkick;

import java.io.FileNotFoundException;

public class Initialization {
	StorageCategory storageCategory = new StorageCategory();
	
	
	public void run() throws FileNotFoundException{
		storageCategory.readAllCatecories();
	}
}
