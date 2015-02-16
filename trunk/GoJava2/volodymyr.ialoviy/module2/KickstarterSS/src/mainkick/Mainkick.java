package mainkick;

public class Mainkick {
    public static void main(String[] args){
    	InputsConsole in = new InputsConsole();
    	OutputConsole out = new OutputConsole();
    	Categories categories = new Categories();
    	Projects projects = new Projects();

    	KickstarterS run = new KickstarterS(in, out, categories, projects);
    	run.kickstarter();
    }
}