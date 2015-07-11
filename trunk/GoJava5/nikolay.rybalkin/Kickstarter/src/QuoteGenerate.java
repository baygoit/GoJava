import java.util.Random;


public class QuoteGenerate {
	
	public String quoteGenerate(){

    	String[] motivators = new String[]{
    			"Get involved in the development of interesting projects!",
    			"Get involved in the development of interesting projects!_1",
    			"Get involved in the development of interesting projects!_2"
    	};
    	int index = new Random().nextInt(motivators.length);
    	String motivator = motivators[index];
    	return motivator;
    }
}
