package categories;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MemoryCard {
	
	public final static String MEMORY_SWITHER = "memory card: off";//if You want to switch it on then change off to on
	public static boolean switcher=false; 
	
Category kickstarter = new Category();	
	
	public Category loadBase() {
		
		try (BufferedReader br = new BufferedReader(new FileReader("source/MemoryCardSettings.txt"))) {
			String memorySetting = "";
			for (; (memorySetting = br.readLine()) != null;) {
				
				if(memorySetting.equals(MEMORY_SWITHER)){
					loadBaseFromFile();
					switcher = true;
				} else {
					loadBaseFromSQL();
				}
			}
		} catch (IOException e) {
			loadBaseFromSQL();
			return kickstarter;
		}
		
		return kickstarter;
	}

	private void loadBaseFromFile() {
		
		try (BufferedReader br = new BufferedReader(new FileReader("source/MemoryCard.txt"))) {
			
			String information = "";
			for (; (information = br.readLine()) != null;) {
				if (information.equals("")){
					break;
				}
				translate(information);
		
			}
		} catch (IOException e) {
			
		}
		
	
	}

	private void translate(String information) {
		
		String field []=information.split("\\|");
		
		int id = Integer.parseInt(field[0]);
		
		kickstarter.category.add(new Project(id, field[1], field[2], field[3], Integer.parseInt(field[4]),
				translateDate(field[6]),
				field[8],
				field[9]));
		
		kickstarter.saveComment(id, new StringBuilder(field[7]));
		kickstarter.setCash(id, Integer.parseInt(field[5]));

	}

	private Calendar translateDate(String field) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("d.MM.yyyy");
		try {
			calendar.setTime(sdf.parse(field));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return calendar;
	}
	
	public void saveBase(Category kickstarter){
		
		String information = kickstarter.saveProject();
		
		try (PrintWriter pw = new PrintWriter("source/MemoryCard.txt")){
			pw.println(information);	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
	}

	public  void loadBaseFromSQL() { 

	SqlDAO sql = new SqlDAO();
	kickstarter = sql.loadBase();
	
	}

}
