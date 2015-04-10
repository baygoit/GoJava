package ua.com.goit.gojava.POM.dataModel.profitcost;

import javax.persistence.*;

@Entity
@Table(name = "cost_items")
public class CostItem {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id = 0;
	
	@Column
	private String name = "";
	
	@Column
	@Enumerated(EnumType.STRING)
	private ProfitLostsType type = ProfitLostsType.LOSTS;
	
	@ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="parent")
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