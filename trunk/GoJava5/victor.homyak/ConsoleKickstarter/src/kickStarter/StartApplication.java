package kickStarter;


public class StartApplication {

	public static void main(String[] args) {
		StartApplication KickStarter = new StartApplication();

		KickStarter.run();

	}

	private void run() {
		QuoteGenerator quote = new QuoteGenerator();

		System.out.println(quote.getQuote());

	}

}
