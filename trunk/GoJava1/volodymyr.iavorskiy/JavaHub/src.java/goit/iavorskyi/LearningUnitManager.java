package goit.iavorskyi;

import goit.iavorskyi.io.Streamer;

import java.util.LinkedList;
import java.util.List;

public class LearningUnitManager {

//	Testing IO
	public static void main(String[] args) {
		Streamer stream = new Streamer();
		String tmp = stream.read("D:\\1.txt");
		stream.write(tmp, "D:\\2.txt");
	}
		
	public List<String> search(String whatToSearch) {
		List <String> result = new LinkedList<String>();
		// TODO make some search engine here.
		return result;
	}
	
	
	
}
