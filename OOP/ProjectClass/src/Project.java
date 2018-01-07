
public class Project {
	private String name;
	private Double cost;
	private String description;
	
	public Project() {
		
		
	}
	public Project(String name) {
		this.setName(name);
	}

	public Project(String name, String description) {
		this.setName(name);
		this.setDescription(description);
	}
	public Project(String name,double cost, String description) {
		this.setName(name);
		this.setCost(cost);
		this.setDescription(description);
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
