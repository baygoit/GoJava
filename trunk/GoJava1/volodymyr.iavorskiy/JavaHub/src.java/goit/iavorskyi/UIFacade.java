package goit.iavorskyi;

import goit.iavorskyi.dao.ArticleDAO;
import goit.iavorskyi.io.Streamer;
import goit.iavorskyi.learningUnit.Article;

import java.util.ArrayList;
import java.util.List;

public class UIFacade {

	/*
	public static void main(String[] args) {
		ArrayList<String> myList = (ArrayList<String>) UIFacade.getArticle();
		for (int i = 0; i < myList.size(); i++) {
			System.out.println(myList.get(i));
		}
	}
	*/
	
	public static void saveArticleToDatabase(String author, String header, String pathToArticle) {
		ArticleDAO articleDAO = new ArticleDAO();
		articleDAO.connectToDatabase();
		articleDAO.insert(author, header, pathToArticle);
		articleDAO.closeConnection();
	}
	
	public List<Article> getAllArticles() {
		ArticleDAO articleDAO = new ArticleDAO();
		articleDAO.connectToDatabase();
		List<Article> result = articleDAO.selectAll();
		articleDAO.closeConnection();
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
