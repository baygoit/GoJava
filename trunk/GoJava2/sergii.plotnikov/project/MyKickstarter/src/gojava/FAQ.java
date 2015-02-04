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
		for(int i = 0; i<faq.size(); i++){
			result+="Q: " + getQuestion(i).getQ() + "\n";
			if(getQuestion(i).getA()!=null){
				result+="A: " + getQuestion(i).getA() + "\n";
			}
		}
		return result;
	}
	
	public void addQuestion(String q){
		Questions question = new Questions(q);
		faq.add(question);
	}
	
	public Questions getQuestion(int i){
		return faq.get(i);
	}
	
	
}
