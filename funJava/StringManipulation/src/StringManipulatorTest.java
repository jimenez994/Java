
public class StringManipulatorTest {
	public static void main(String[] args) {
		StringManapulator manipulator = new StringManapulator();
		
//		Trim both input strings and then concatenate them. Return the new string.
		String str = manipulator.trimAndConcat("    Hello     ","     World    ");
		System.out.println(str); // HelloWorld 
		
//		Get the index of the character and return either the index or null. If the character appears multiple times, return the first index.
		char letter = 'o';
		Integer a = manipulator.getIndexOrNull("Cjgjoding", letter);
		Integer b = manipulator.getIndexOrNull("Hello World", letter);
		Integer c = manipulator.getIndexOrNull("Hi", letter);
		System.out.println(a); // 1
		System.out.println(b); // 4
		System.out.println(c); // null
		
//		Get the index of the start of the substring and return either the index or null.
		String word = "Hello";
		String subString = "llo";
		String notSubString = "world";
		Integer t = manipulator.getIndexOrNull(word, subString);
		Integer g = manipulator.getIndexOrNull(word, notSubString);
		System.out.println("get index or null = " + t); // 2
		System.out.println("get index or null = " +  g); // null
		
		
//		Get a substring using a starting and ending index, and concatenate that with the second string input to our method.
		String str4 = manipulator.concatSubstring("Hello", 1, 2, "world");
		System.out.println(str4); // eworld


		
		
	}

}
