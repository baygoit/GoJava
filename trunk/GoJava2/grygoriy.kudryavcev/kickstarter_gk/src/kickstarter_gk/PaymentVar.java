package kickstarter_gk;

public class PaymentVar {

	private Project project;
	private Float summ;
	private String desc;
	
	public PaymentVar(Project project, Float summ, String desc) {
		super();
		this.project = project;
		this.summ = summ;
		this.desc = desc;
	}
	
	public Project getProject() {
		return project;
	}
	
	public float getSumm(){
		return summ;
	}
	
	public String getDesc(){
		return desc;
	}
	
}

		
