package goit.iavorskyi;

import goit.iavorskyi.dao.ArticleDAO;
import goit.iavorskyi.io.Streamer;
import goit.iavorskyi.learningUnit.Article;

import java.util.ArrayList;
import java.util.List;

public class UIFacade {

	public static void saveArticleToDatabase(String author, String header, String pathToArticle) {
		ArticleDAO articleDAO = new ArticleDAO();
		articleDAO.insert(author, header, pathToArticle);
	}
	
	public static List<Article> getAllArticles() {
		ArticleDAO articleDAO = new ArticleDAO();
		List<Article> result = articleDAO.selectAll();
		return result;
	}
	
	public static List<String> getArticle() {
		ArrayList<String> result = new ArrayList<String>();
		String regexp = " ";
		try {
			String[] arr = Streamer.read("d:\\Article.txt").split(regexp);
			for (int i = 0; i < arr.length; i++) {
				result.add(arr[i]);
		}
			
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return result;
	}
}
