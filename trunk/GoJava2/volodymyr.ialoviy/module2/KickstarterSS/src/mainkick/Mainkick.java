package mainkick;

public class Mainkick {
    public static void main(String[] args){
    	Check check = new Check(new InputsConsole(), new OutputConsole());
    	Output out = new OutputConsole();
    	Categories categories = new Categories();
    	Category category = new Category();
    	Projects projects = new Projects();
    	Project project = new Project();
    	
    	
    	
    	KickstarterS run = new KickstarterS(check, out, categories, category, projects, project);
    	run.kickstarter();
    }
}