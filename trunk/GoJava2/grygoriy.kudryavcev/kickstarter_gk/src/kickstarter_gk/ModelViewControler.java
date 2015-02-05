package kickstarter_gk;

public class ModelViewControler {

	 public ModelViewControler() {

	       
		    Model model = new Model();
	        View view = new View();
	        Scaner scaner = new Scaner();
	        Controler controler = new Controler(model, view, scaner);

	        controler.start();
	    }
	
}
