package kickstarter.interfaces;

import kickstarter.data_types.Data;
import storages.Storage;

public interface Printer {
	public void showMessage(String message);

	public Data showItem(String item);

	public Data choiceItem(String message, Storage<? extends Data> storage);
}
