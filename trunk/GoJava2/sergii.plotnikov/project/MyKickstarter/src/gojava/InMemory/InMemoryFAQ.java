package gojava.InMemory;
import gojava.Questions;
import gojava.Interface.FAQ;

import java.util.ArrayList;

public class InMemoryFAQ implements FAQ {
	private ArrayList<Questions> faq;
	
	public InMemoryFAQ(){
		faq = new ArrayList<Questions>();
		for(int i = 0; i<3; i++){
			Questions q = new Questions();
			faq.add(q);
		}
	}
	
	@Override
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
	
	@Override
	public void addQuestion(String q){ faq.add(new Questions(q));}
	
	public Questions getQuestion(int i){ return faq.get(i);}
}
