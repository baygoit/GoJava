package goit.iavorskyi;

import goit.iavorskyi.dao.ArticleDao;
import goit.iavorskyi.io.Streamer;
import goit.iavorskyi.learningUnit.Article;

public class DBFacade {
	public static void saveArticle(Article articleToSave) {
		String linkToText = Streamer.write(articleToSave.getText());
		ArticleDao articleDAO = new ArticleDao();
		articleDAO.insert(articleToSave.getAuthor(), articleToSave.getHeader(), linkToText);
	}
}
