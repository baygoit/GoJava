package ua.com.goit.gojava.myshko;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectOfficeManagement {

	private static final int COLUMN_LENGTH = 20;
	private static final String DATA_FILE = "C:\\workspace\\ProjectOfficeManagement.dat";
	
	private List<ProjectPNLDescribe> ProjectPNL = new ArrayList<ProjectPNLDescribe>();
	
	private static class ProjectPNLDescribe implements Serializable {
		
		private static final long serialVersionUID = 5647586379308687876L;
		
		private String projectName;
		private String costItem;
		private long sum;
		
		public ProjectPNLDescribe(String projectName, String costItem, long sum) {

			this.projectName = projectName;
			this.costItem = costItem;
			this.sum = sum;
		}
		
		public static void showTitle() {
			
			String formatString = "%-" + (COLUMN_LENGTH) + "s"; 
			System.out.format(formatString,"Project name");
			System.out.format(formatString,"Cost item name");
			System.out.format(formatString,"Sum");
			
			System.out.println("");
			for (int i = 0; i < COLUMN_LENGTH *3; i++) {
				System.out.print("-");
			}
			System.out.println("");
			
		}
		
		public void show() {
			
			String formatString = "%-" + (COLUMN_LENGTH) + "s"; 
			System.out.format(formatString,"" + projectName);
			System.out.format(formatString,"" + costItem);
			
			formatString = "%" + (COLUMN_LENGTH) + "s"; 
			System.out.format(formatString,"" + sum);
			
			System.out.println("");
			
		}
		
	}
	
	public ProjectOfficeManagement() {

		try {
			readProjectPNL();
		} catch (Throwable e) {
			
			//Logger.getLogger("ProjectOfficeManagement.class").log(Level.SEVERE , "Cannot read ProjectPNL!");
			//e.printStackTrace();
			Logger.getLogger("ProjectOfficeManagement.class").log(Level.SEVERE , "Cannot read Data File! File will be created or overriden");	
		}
		
	}

	private void show() {
		
		ProjectPNLDescribe.showTitle();
		
		for (int i = 0; i < ProjectPNL.size(); i++) {
		
			ProjectPNL.get(i).show();
			
		}
		
	}
	
	private void update() {
		
		System.out.println("Input Project, Cost item and Sum, separated by '; ' and press Enter or press Enter for exit");
		
		Scanner sc = new Scanner(System.in); 
		while (sc.hasNextLine()) {
			
			String enteredString = sc.nextLine();
			
			if (enteredString.isEmpty()) {
				break;
			}
			
			String[] enteredStringArray = enteredString.split("; ");
			
			if (enteredStringArray.length != 3) {
				System.out.println("You can input 3 value, separated by '; ': Project, Cost item and Sum !");
			} else {
				
				long sum = 0;
				
				try {
					sum =  Integer.parseInt(enteredStringArray[2]);
				} catch (NumberFormatException e) {		

					Logger.getLogger("Division.class").log(Level.SEVERE , "Cannot convert entered sum to int!");
					continue;
				}
				
				ProjectPNL.add( new ProjectPNLDescribe(enteredStringArray[0], enteredStringArray[1], sum));
				
			}
		
		};
		
		sc.close();
		
		try {
			saveProjectPNL();
		} catch (IOException e) {
			
		} 
		
	}

	private void saveProjectPNL() throws IOException {
		
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			
			fos = new FileOutputStream(DATA_FILE);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(ProjectPNL);
			oos.close();
			fos.close();
				
		} catch (IOException e) {
			
			Logger.getLogger("ProjectOfficeManagement.class").log(Level.SEVERE , "Cannot save ProjectPNL!");
			//e.printStackTrace();
			throw e;
		}
		
	}
	
	private void readProjectPNL() throws Throwable {
		
		FileInputStream fis;
		ObjectInputStream ois;
		try {
			
			fis = new FileInputStream(DATA_FILE);
			ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
					
			if(obj instanceof ArrayList<?> ) {
				ProjectPNL = (ArrayList <ProjectPNLDescribe>) obj;
			}
		
			ois.close();
			fis.close();
			
		} catch (IOException | ClassNotFoundException e) {
			
			throw e;
		}
		
	}
	
	private static void runProjectOfficeManagement(String mode) {

		if (mode.contentEquals("-show")) {
		
			ProjectOfficeManagement manager = new ProjectOfficeManagement();
			manager.show();
			
		} else if (mode.contentEquals("-update")) {

			ProjectOfficeManagement manager = new ProjectOfficeManagement();
			manager.update();
			
		}
		
	}
	
	public static void main(String[] args) {

		if ((args.length != 1)
				||(	!(args[0].contentEquals("-show"))
						&&( !(args[0].contentEquals("-update")) ) )) {
			System.out.println("You must run program with key '-show' or '-update'.");
			return;
		}
		
		runProjectOfficeManagement(args[0]);

	}

}