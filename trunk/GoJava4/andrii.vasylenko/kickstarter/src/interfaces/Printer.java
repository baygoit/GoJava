package interfaces;

import storages.Storage;
import data_types.Data;

public interface Printer {
	public void showMessage(String message);

	public Data showItem(String item);

	public Data choiceItem(String message, Storage<? extends Data> storage);
}
