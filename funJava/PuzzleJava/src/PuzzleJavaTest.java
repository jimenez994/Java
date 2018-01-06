import java.util.ArrayList;

public class PuzzleJavaTest {
	public static void main(String[] args) {
		PuzzleJava a = new PuzzleJava();
		int[] myArray = {3,5,1,2,7,9,8,13,25,32};
		String[] strArray = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		
		ArrayList<Integer> arr = a.task1(myArray);
		System.out.println(arr);
		
		ArrayList<String> arr2 = a.task2(strArray);
		System.out.println(arr2);
		
		a.task3(alphabet);
		
		ArrayList<Integer> arr4 = a.task4();
		System.out.println(arr4);
		
		a.task5();
		
		a.task6();
		
	}
}
