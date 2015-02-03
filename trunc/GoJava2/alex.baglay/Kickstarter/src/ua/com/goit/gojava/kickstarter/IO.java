package ua.com.goit.gojava.kickstarter;

// абстракция в чистом виде. Глядя на нее нам про Консоль ничего не сказать. Реализаций может быть сколь угодно много
// EmailIO, WifiIO, BlaBlaIO....

public interface IO {

	int read();

	void print(String message);

}