import java.util.ArrayList;
public class BasicJava {
	public void print255() {
		for (int i = 1; i <= 255; i++) {
			System.out.println("# "+i);
		}	
		
	}
	public void printOdd255() {
		for (int i = 1; i <= 255; i+=2) {
			System.out.println("odd " + i);
		}	
		
	}
	public void printsum255() {
		int num = 0;
		for (int i = 0; i <= 255; i++) {
			int sum = num + i;
			num = i;
			System.out.println("New number:" + i + " Sum " + sum);
		}	
		
	}
	
	public void iteratingArray(int[] arr) {
		for (int i = 0; i <= arr.length -1; i++) {
			
			System.out.println("# "+ arr[i] );
		}
	}
	
	public void findMax(int[] arr) {
		int temp = 0;
		for (int i = 0; i <= arr.length -1; i++) {
			temp = arr[i];
			if(arr[i] > temp) {
				temp = arr[i];
			}
		}
		System.out.println("Max: " + temp);
	}
	
	public void getAverage(int[] arr) {
		double sum = 0;
		for (int i = 0; i <= arr.length -1; i++) {
			sum += arr[i];
		}
		System.out.println("Average: "+ sum/arr.length );
	}
	public void arrayOdd255() {
		ArrayList<Integer> myArray = new ArrayList<Integer>();
		for (int i = 1; i <= 255; i+=2) {
			myArray.add(i);
		}	
		System.out.println("Array Odds: " + myArray);	
	}
	public void greaterThanY(int[] arr, int y) {
		int counter = 0;
		for (int i = 0; i <= arr.length -1; i++) {
			if(arr[i] > y) {
				counter++;
			}
		}
		System.out.println("Greater than y: " + counter);
	}
	
	
}
