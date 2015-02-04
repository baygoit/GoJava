package gojava;

public class Questions {
	private String Q;
	private String A;
	
	public Questions(){
		Q = "this is a question";
		A = "this is an answer";
	}
	
	public Questions(String Q){
		this.Q=Q;
	}

	public String getQ() { return Q;}
	
	public String getA() { return A;}
	
}
