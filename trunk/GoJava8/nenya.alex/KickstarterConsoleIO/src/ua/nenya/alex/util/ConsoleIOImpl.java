package ua.nenya.alex.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ConsoleIOImpl implements IO {

	@Override
	public void writeln(String str) {
		System.out.println(str);
	}

	@Override
	public void write(String str) {
		System.out.print(str);
	}

	@Override
	public String readConsole() {
		String result = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			result = reader.readLine();
		} catch (IOException e) {
			writeln("Wrong entering!");
		}
		return result;
	}

	@Override
	public List<String> read(String fileName) {
		List<String> list = new ArrayList<>();
		try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			while (reader.ready()) {
				String str = reader.readLine();
				if (!str.isEmpty()) {
					list.add(str);
				}
			}
			reader.close();
		} catch (IOException e) {
		}
		return list;
	}

	@Override
	public void writeFile(String fileName, String str) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true))) {
			writer.newLine();
			writer.write(str);
		} catch (IOException e) {

		}

	}


	@Override
	public void writeEmpty() {
		System.out.println();
	}

}
