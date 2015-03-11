import goit.iavorskyi.dao.ArticleDAO;


public class Starter {

	public static void main(String[] args) {
		
		ArticleDAO articleDAO = new ArticleDAO();
		articleDAO.selectAll();
		
		
//		articleDAO.insert("Vova", "Interesting article", "d:\\article.txt");
//		System.out.print("1" + "\n" + "2");
		
	}

}
