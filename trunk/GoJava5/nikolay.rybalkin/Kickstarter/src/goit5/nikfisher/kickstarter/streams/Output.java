package goit5.nikfisher.kickstarter.streams;

public class Output implements Write {

	public void println(String result){
		System.out.println(result);
	}

	public void print(String result){
		System.out.print(result);
	}
}