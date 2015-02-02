package gojava;
import java.util.ArrayList;


public class FAQ {
	private ArrayList<Questions> faq = new ArrayList<Questions>();
	
	public FAQ(){
		for(int i = 0; i<3; i++){
			Questions q = new Questions();
			faq.add(q);
		}
	}
	
	public String showFAQ() {
		String result ="";
		for(int i = 0; i<3; i++){
			result+="Q: " + getQuestion(i).getQ() + "\n";
			result+="A: " + getQuestion(i).getA() + "\n";
		}
		return result;
	}
	
	public Questions getQuestion(int i){
		return faq.get(i);
	}

}
