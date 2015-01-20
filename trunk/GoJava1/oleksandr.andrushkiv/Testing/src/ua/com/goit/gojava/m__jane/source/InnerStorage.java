package ua.com.goit.gojava.m__jane.source;

import java.util.Arrays;
import java.util.List;

public class InnerStorage {
	
	 private final static String[] questions;
	 private final static String[] profiles;
	 private final static String[] questionCategories;
	 public final String splitter = "`";
     		     
	    static {
	    	questions = new String[6];
	    	//id`content`questionCategory_id`profile_id`openQuestion
	        questions[0] = "1`Як має поводитись продавець у торговому залі, якщо Покупець змушений чекати?`1`1`true";
	        questions[1] = "2`Яким є завдання продавця на етапі «Презентація товару»?`2`1`false";
	        questions[2] = "3`Як продавець має презентувати товар Покупцю?`1`1`true";
	        questions[3] = "4`В чому полягає суть методу презентації Т-Х-В? Наведіть приклад по товару з вашого відділу.`2`1`true";
	        questions[4] = "5`Назвіть основні етапи продажу`1`2`false";
	        questions[5] = "6`Яким є завдання продавця на етапі «Зустріч покупця»?`3`1`true";
//	        questions[6] = "Як необхідно працювати із запереченнями Покупця?";
//	        questions[7] = "Що не можна робити на етапі «Відповіді на заперечення»?";
//	        questions[8] = "Що таке комплексний продаж? Наведіть приклад.";
//	        questions[9] = "Чому продавець повинен завжди здійснювати комплексний продаж?";
	        
	        questionCategories = new String[3];
	        questionCategories[0] = "1`Продавець";
	        questionCategories[1] = "2`Старший продавець";
	        questionCategories[2] = "3`Босс";

	        
	        profiles = new String[2];
	        profiles[0] = "1`Торгові питання";
	        profiles[1] = "2`Законодавство";
	             
	    }

	    
	    public List<String> getQuestions() {
	        return Arrays.asList(questions);
	    }
	    public List<String> getQuestionCategories() {
	        return Arrays.asList(questionCategories);
	    }
	    public List<String> getProfiles() {
	        return Arrays.asList(profiles);
	    }
	    
	
}
