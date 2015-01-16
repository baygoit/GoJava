package ua.com.goit.gojava.m__jane.source;

import java.util.Arrays;
import java.util.List;

public class InnerStorage {
	
	 private final static String[] questions;
     		     
	    static {
	    	questions = new String[10];
	        questions[0] = "Як має поводитись продавець у торговому залі, якщо Покупець змушений чекати?";
	        questions[1] = "Яким є завдання продавця на етапі «Презентація товару»?";
	        questions[2] = "Як продавець має презентувати товар Покупцю?";
	        questions[3] = "В чому полягає суть методу презентації Т-Х-В? Наведіть приклад по товару з вашого відділу.";
	        questions[4] = "Назвіть основні етапи продажу";
	        questions[5] = "Яким є завдання продавця на етапі «Зустріч покупця»?";
	        questions[6] = "Як необхідно працювати із запереченнями Покупця?";
	        questions[7] = "Що не можна робити на етапі «Відповіді на заперечення»?";
	        questions[8] = "Що таке комплексний продаж? Наведіть приклад.";
	        questions[9] = "Чому продавець повинен завжди здійснювати комплексний продаж?";
	    }

	    
	    public List<String> getQuestions() {
	        return Arrays.asList(questions);
	    }
}
