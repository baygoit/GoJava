package interfaces;

import java.io.InputStreamReader;
import java.util.Scanner;

import storages.Storage;
import data_types.Data;

public class ConsolePrinter implements Printer {
	public static final int NUMBER_OF_EXIT_ITEM = 0;

	@Override
	public void showMessage(String message) {
		System.out.println(message);
	}

	@Override
	public Data showItem(String item) {
		return choiceItem(item, null);
	}

	@Override
	public Data choiceItem(String message, Storage<? extends Data> storage) {
		while (true) {
			try {
				return showChoiceItemDialog(message, storage);
			} catch (IndexOutOfBoundsException ignore) {
			} catch (NumberFormatException ignore) {
			}
			showMessage("--------------------");
			showMessage("try again please");
		}
	}

	private Data showChoiceItemDialog(String message, Storage<? extends Data> storage) {
		int itemId = choiceItemId(message, getItems(storage));
		if (itemId == NUMBER_OF_EXIT_ITEM) {
			return Data.Default.EXIT;
		}
		return getItemById(itemId, storage);
	}

	private Data getItemById(int id, Storage<? extends Data> storage) {
		if (storage == null) {
			throw new IndexOutOfBoundsException();
		}
		Data result = storage.getById(id);
		return result;
	}

	private int choiceItemId(String message, String items) {
		showMessage("--------------------");
		showMessage(message);
		showMessage(items);
		return readInt();
	}

	private String getItems(Storage<? extends Data> storage) {
		StringBuilder result = new StringBuilder();

		if (storage != null) {
			for (int i = 0; i < storage.size(); i++) {
				result.append(storage.get(i).toString());
				result.append("\r\n");
			}
		}

		result.append(NUMBER_OF_EXIT_ITEM + " - exit");

		return result.toString();
	}

	private int readInt() throws NumberFormatException {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		if (scanner.hasNextInt()) {
			return scanner.nextInt();
		}
		throw new NumberFormatException();
	}

}
