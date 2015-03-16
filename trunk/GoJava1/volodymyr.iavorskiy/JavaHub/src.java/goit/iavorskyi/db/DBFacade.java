package goit.iavorskyi.db;

import goit.iavorskyi.domain.Article;
import goit.iavorskyi.domain.Streamer;

public class DBFacade {
	public static void saveArticle(Article articleToSave) {
		String linkToText = Streamer.write(articleToSave.getText());
		ArticleDao articleDAO = new ArticleDao();
		articleDAO.insert(articleToSave.getAuthor(), articleToSave.getHeader(), linkToText);
	}
}
