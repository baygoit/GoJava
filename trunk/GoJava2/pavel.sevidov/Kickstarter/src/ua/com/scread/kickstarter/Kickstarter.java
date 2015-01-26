package ua.com.scread.kickstarter;

public class Kickstarter {
	/* 
	*	UserStory I 
	*	Как гость (инвестор) я хочу видеть на главной страничке сайта побуждающую к творчеству 
	*	цитату чтобы заинтересовать мое внимание
	*	Сценарий: захожу в приложение -> вижу цитату
	*/
	
	public static void main(String[] arguments) {
		QuoteGenerator quote = new QuoteGenerator();
		System.out.println(quote.getQuote());
	}
	
	
	

}
