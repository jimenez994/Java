
public class projectTest {
	public static void main(String[] args) {
		
		Project p = new Project("pizza",5.99,"is food");
		String name = p.getName();
		Double cost = p.getCost();
		String desc = p.getDescription();
		
		
		System.out.println(name +" $"+ cost+": "+desc);
		
	}

}
