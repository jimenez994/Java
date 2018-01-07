
public class SinglyLinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SinglyLinkedList sl = new SinglyLinkedList();
		sl.add(5).add(33).add(66).add(98);
	
		sl.printValues();
		sl.removeAt(66);
		sl.printValues();
		
//		sl.find(5);
		
//		System.out.println(sl);

	}

}
