package goit.iavorskyi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Streamer {

	public String read(String fileToRead) {
		String result = "";
		try (BufferedReader br = new BufferedReader(new FileReader(fileToRead))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			result = sb.toString();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void write(String stringToWrite, String fileToWrite) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWrite))) {
			bw.write(stringToWrite);
		}
		catch (Exception e) {
			 e.printStackTrace();
		}
	}

}
