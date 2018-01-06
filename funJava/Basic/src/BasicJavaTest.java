
public class BasicJavaTest {
	public static void main(String[] args) {
		BasicJava a = new BasicJava();
		a.print255();
		a.printOdd255();
		a.printsum255();
		
		int[] myArray = {-4, 8, 8, 5, 9};
		int y = 7;
		
		a.iteratingArray(myArray);
		a.findMax(myArray);
		a.getAverage(myArray);
		a.arrayOdd255();
		a.greaterThanY(myArray, y);
		a.squareValues(myArray);
		a.eliminateNegatives(myArray);
		
		double[] myArray2 = {-4, 8, 8, 5, 9};
		a.maxMinAverage(myArray2);
		a.shiftValueArray(myArray);
	}
	
}
