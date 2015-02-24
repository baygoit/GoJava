package goit.iavorskyi.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Streamer {

	
	private static String fileToWriteIn = "d:\\Article.txt";
	
	public static String read(String fileToRead) {
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
	
	public static void write(String stringToWrite) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWriteIn));
			bw.write(stringToWrite);
			bw.close();
		}
		catch (Exception e) {
			 e.printStackTrace();
		}
	}

}
