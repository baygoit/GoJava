package kickstarter_gk;
import java.util.ArrayList;

public class Citation {

	 public String outCitation () {
		 
		 ArrayList<String> allCitations = new ArrayList();
		 
		 allCitations.add("Нет попутного ветра для того, кто не знает, в какую гавань он хочет приплыть. (с) Монтень");
		 allCitations.add("Самый краткий путь к завоеванию славы - это делать по побуждению совести то, что мы делаем ради славы.");
		 allCitations.add("Терпение и время дают больше чем сила и страсть. (с) Лафонтен");
		 allCitations.add("Земле нужны не новые континенты, а новые люди. (с) Жюль Верн");
		 allCitations.add("Неизвестно, кто первый открыл воду, но уж наверняка это сделали не рыбы. (с) Стругацкие");
		 		 
		 int rnd = (int)(Math.random()*allCitations.size());
		 		 		 
		 String cit =  allCitations.get(rnd);
		 
		 return cit;
	 }
	
}
