package ua.com.goit.gojava.kickstarter.input_output;




public class Reader  {
	private Input consolReader;
	
	public Reader(Input reader){
	this.consolReader = reader;
	}
	
	public int readInt() {
		return Integer.valueOf(consolReader.read());
	}
	
	
	
	
}
