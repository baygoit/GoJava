package ua.com.goit.gojava.POM.dataModel.profitcost;

public class CostItem {
	
	private long id = 0;
	private String name = "";
	private ProfitLostsType type = ProfitLostsType.LOSTS;
	private CostItem parent;
	
	public long getId() {
		
		return id;
		
	}
	
	public void setId(long id) {
		
		this.id = id;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public ProfitLostsType getType() {
		
		return type;
		
	}
	
	public void setType(ProfitLostsType type) {
		
		this.type = type;
		
	}
	
	public CostItem getParent() {
		
		return parent;
		
	}
	
	public void setParent(CostItem parent) {
		
		this.parent = parent;
		
	}

	public long getParentId() {
		
		long parentID = 0;
		if(parent != null) {
			parentID = parent.getId();
		}
		
		return parentID;
	}

}