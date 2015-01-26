import java.util.ArrayList;


public class FAQ {
	private ArrayList<Questions> faq = new ArrayList<Questions>();
	
	public FAQ(){
		for(int i = 0; i<3; i++){
			Questions q = new Questions();
			faq.add(q);
		}
	}
	
	public void showFAQ() {
		for(int i = 0; i<3; i++){
			System.out.println("Q: " + getQuestion(i).getQ());
			System.out.println("A: " + getQuestion(i).getA());
		}
	}
	
	public Questions getQuestion(int i){
		return faq.get(i);
	}

}
