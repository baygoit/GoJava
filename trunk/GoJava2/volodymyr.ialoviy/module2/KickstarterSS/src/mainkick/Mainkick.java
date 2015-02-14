package mainkick;

public class Mainkick {
    public static void main(String[] args){
    	InputChecker check = new InputChecker(new InputsConsole(), new OutputConsole());
    	Output out = new OutputConsole();
    	Categories categories = new Categories();
    	Projects projects = new Projects();

    	KickstarterS run = new KickstarterS(check, out, categories, projects);
    	run.kickstarter();
    }
}