package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class CategoriesFromDB implements Categories{

	public static void main(String[] args) {
		CategoriesFromDB cat = new CategoriesFromDB();
		Projects projects = new ProjectsFromFile();
		System.out.println(cat.showAllCatecoriesInKickstarter());
		System.out.println(cat.showAllProjectInCategory(1, projects));
		System.out.println(cat.showCatecoryName(2));
		System.out.println(Arrays.toString(cat.getKickCategories()));
		System.out.println(Arrays.toString(cat.projectsThatAreContainedInTheCategory(1)));
		
	}
	
	@Override
	public String showAllCatecoriesInKickstarter() {
		StringBuilder s = new StringBuilder();
		TemlateForMethodWithDB temp = new TemlateForMethodWithDB(){
			@Override
			void logic(Statement statement) throws SQLException {
				ResultSet result = statement.executeQuery("SELECT * FROM categories");
				while (result.next()) {
				    s.append(result.getInt("id_category"))
				    		.append(" ")
				    		.append(result.getString("name_category"))
				    		.append("\n").toString();
				}
			}
		};
		temp.templateWorkWithDB();
		return s.substring(0, s.length() - 1);
	}

	@Override
	public String showAllProjectInCategory(int categoryId, Projects projects) {
		StringBuilder s = new StringBuilder();
		TemlateForMethodWithDB temp = new TemlateForMethodWithDB(){
			@Override
			void logic(Statement statement) throws SQLException {
				ResultSet result = statement.executeQuery("SELECT * FROM projects WHERE id_category =" + categoryId + "ORDER BY id_project");
	            while (result.next()) {
	                s.append(result.getInt("id_project"))
	                	.append(", ").append(result.getString("name_project"))
						.append(", ").append(result.getString("short_description_project"))
						.append(", ").append(result.getString("how_much_needed_project"))
						.append(", ").append(result.getString("how_much_collected_project"))
						.append("\n").toString();
	            }
			}
		};
		temp.templateWorkWithDB();
		return s.substring(0, s.length() - 1);
	}

	@Override
	public String showCatecoryName(int categoryId) {
		StringBuilder s = new StringBuilder();
		TemlateForMethodWithDB temp = new TemlateForMethodWithDB(){
			@Override
			void logic(Statement statement) throws SQLException {
				ResultSet result = statement.executeQuery("SELECT * FROM categories WHERE id_category =" + categoryId);
	            while (result.next()) {
	                s.append(result.getString("name_category")).toString();
	            }
			}
		};
		temp.templateWorkWithDB();
		return s.toString();
	}

	@Override
	public int[] getKickCategories() {
		ArrayList<Integer> array = new ArrayList<Integer>();
		TemlateForMethodWithDB temp = new TemlateForMethodWithDB(){
			@Override
			void logic(Statement statement) throws SQLException {
	            ResultSet result = statement.executeQuery("SELECT * FROM categories");
	            while (result.next()) {
	            	array.add(result.getInt("id_category"));
	            }
			}
		};
		temp.templateWorkWithDB();
        int[] a = new int[array.size()];
        int j = 0;
        for (Integer i : array){
        	a[j] = i;
        	j++;
        }
		return a;
	}

	@Override
	public int[] projectsThatAreContainedInTheCategory(int categoryId) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		TemlateForMethodWithDB temp = new TemlateForMethodWithDB(){
			@Override
			void logic(Statement statement) throws SQLException {
	            ResultSet result = statement.executeQuery("SELECT id_category, id_project FROM projects WHERE id_category =" + categoryId + "ORDER BY id_project");
	            while (result.next()) {
	            	array.add(result.getInt("id_project"));
	            }
			}
		};
		temp.templateWorkWithDB();
        int[] a = new int[array.size()];
        int j = 0;
        for (Integer i : array){
        	a[j] = i;
        	j++;
        }
		return a;
	}

	@Override
	public int getCounterCategory() {
		// do nothing
		return 0; //TODO DELETE null (NPE)
	}
	
	@Override
	public ArrayList<Category> getListCatecories() {
		// do nothing
		return null; //TODO DELETE null (NPE)
	}
	
	@Override
	public void writeAllCatecories() {
		// do nothing
	}

	@Override
	public void setCounterCategory(int counterCategory) {
		// do nothing
	}

	@Override
	public void setListCatecories(ArrayList<Category> listCatecories) {
		// do nothing
	}
}