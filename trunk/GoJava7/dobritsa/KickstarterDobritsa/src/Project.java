public class Project{
	private String number;
    private String description;
    private Integer goal;
    private Integer pledged;
    private Integer daysToGo;
    public Project(String name, String d, Integer g, Integer p, Integer dtg){         
        number=name;
    	description=d;
        goal=g;
        pledged = p;
        daysToGo=dtg;
    }
    
    String getNumber(){return number;}
    String getDescription(){return description;}
    Integer getAmount(){return goal;}
    Integer getPledged(){return pledged;}
    Integer getDaysToGo(){return daysToGo;}
    
    public void printAll() {
    	System.out.println("Number: " + number);
    	System.out.println("Short description: " + description);
    	System.out.println("Goal: " + goal);
    	System.out.println("Pledged: " + pledged);
    	System.out.println("Days to go: " + daysToGo);
    }
}