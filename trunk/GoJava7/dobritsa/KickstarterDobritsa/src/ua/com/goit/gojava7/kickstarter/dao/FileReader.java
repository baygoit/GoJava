package ua.com.goit.gojava7.kickstarter.dao;

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
	BufferedReader fileReader = null;

	public FileReader(File file) {
		this.file = file;
	}

	public List<T> read() {
		data = new ArrayList<>();
		try {
			InputStream quotesFileSteam = new FileInputStream(file);
			fileReader = new BufferedReader(new InputStreamReader(quotesFileSteam));
			data = readIt();
		} catch (IOException e) {
			throw new IllegalStateException("File not found or read error", e);
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					System.err.println("Cannot close file " + file);
				}
			}
		}
		if (data.isEmpty()) {
			throw new IllegalStateException("There is not quotes in file");
		}
		return data;
	}

	public List<T> readIt() throws IOException {
		return data;
	}

}
