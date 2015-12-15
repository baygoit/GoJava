package ua.com.goit.gojava7.kickstarter.dao.file.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public abstract class FileReader<T> {

	private File file;
	protected List<T> data;

	public FileReader(File file) {
		this.file = file;
	}

	public List<T> read() {
		data = new ArrayList<>();
		try (InputStream inputStream = new FileInputStream(file);
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
			data = readFromFile(bufferedReader);
		} catch (IOException e) {
			throw new IllegalStateException("File not found or read error " + file, e);
		}

		if (data.isEmpty()) {
			throw new IllegalStateException("There are not dates in file " + file);
		}
		return data;
	}

	public List<T> readFromFile(BufferedReader bufferedReader) throws IOException {
		return data;
	}

}
