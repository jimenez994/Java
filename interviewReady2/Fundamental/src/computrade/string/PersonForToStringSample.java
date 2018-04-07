package computrade.string;

public class PersonForToStringSample {

	private String firstName;
	private String lastName;
	private String id;
	
	public PersonForToStringSample(String firstName, String lastName, String id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}
	
	public static void main(String[] args) {
		
		PersonForToStringSample person = new PersonForToStringSample("Yuval","Ishay","02564");
		System.out.println(person);

	}

	@Override
	public String toString() {
		return "PersonForToStringSample [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + "]";
	}

	
	

}
