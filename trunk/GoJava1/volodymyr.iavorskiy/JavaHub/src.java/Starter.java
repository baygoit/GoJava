import goit.iavorskyi.dao.ArticleDAO;


public class Starter {

	public static void main(String[] args) {
		
		ArticleDAO articleDAO = new ArticleDAO();
		articleDAO.connectToDatabase();
		articleDAO.insert("Vova", "Interesting article", "d:\\article.txt");
		articleDAO.closeConnection();
		
	}

}
