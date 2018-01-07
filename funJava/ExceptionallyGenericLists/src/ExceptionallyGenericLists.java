import java.util.ArrayList;

public class ExceptionallyGenericLists {
	public static void main(String[] args) {
		ArrayList<Integer> myList = new ArrayList<Integer>();
		myList.add("13");
		myList.add("hello world");
		myList.add(48);
		myList.add("Goodbye World");
		
		for(int i = 0; i <= myList.size()-1;i++) {
			try {
				Integer castedValue = (Integer) myList.get(i);
				System.out.println(castedValue);
			}catch (ClassCastException e){
				System.out.println("You can't do that");
				
				
			}
		}
		for(int i = 0; i <= myList.size()-1;i++) {
			Integer castedValue = (Integer) myList.get(i);
			
			
				System.out.println(castedValue);
			
			}
		}

}
