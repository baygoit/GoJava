package ua.kutsenko.KickstarterGoIt.dao;

import ua.kutsenko.KickstarterGoIt.domain.Quote;

public class QuoteDaoMemory extends QuoteDao {
private int quoteId = 1;

	
	@Override
	public void fillQuotes() {
		quotes.add(new Quote("Клевета как уголь: не обожжет, так замарает.", "Вася"));
		quotes.add(new Quote("Помирать собрался, а жито сей..", "Петро"));
		quotes.add(new Quote("Утро вечера мудренее.", "Вася"));
		quotes.add(new Quote("Плох тот солдат, который не думает быть генералом.", "Геннадий"));
		quotes.add(new Quote("У Фили пили, да Филю ж и били.", "Вася"));
		
		
	}

}
