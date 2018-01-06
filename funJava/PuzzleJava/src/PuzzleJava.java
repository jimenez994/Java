import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class PuzzleJava {
	public ArrayList<Integer> task1(int[] arr) {
		int num = 0;
		ArrayList<Integer> myArray = new ArrayList<Integer>();
		for(int i = 0; i <= arr.length - 1; i++) {
			if(arr[i] > 10) {
				myArray.add(arr[i]);
			}
			num = num + arr[i];
			System.out.println(" Sum: " + num);	
		}
		return myArray;
		
	}
	public ArrayList<String> task2(String[] arr) {
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(arr));
		Collections.shuffle(list);
		ArrayList<String> myArray = new ArrayList<String>();
		for(int i = 0; i <= list.size() - 1; i++) {
			System.out.println(list.get(i));
			if(list.get(i).length() > 5) {
				myArray.add(list.get(i));
			}
		}
		return myArray;
	}
	public void task3(char[] arr) {
		ArrayList<Character> list = new ArrayList<Character>();
		for(int i = 0; i <= arr.length -1; i++) {
			list.add(arr[i]);
		}
		Collections.shuffle(list);
		char z = list.get(0);
		 if(z=='a'||z=='e'||z=='i'||z=='o'||z=='u') {
			 System.out.println(list.get(0) + " <- This is a vowel " + list.get(arr.length -1));
		 }else {
		 System.out.println(list.get(0) + " " + list.get(arr.length -1));
		 }
	}
	public ArrayList<Integer> task4() {
		Random r = new Random();
		int num = 0;
		ArrayList<Integer> myArray = new ArrayList<Integer>();
		for(int i = 1; i <= 10; i++) {
			num = r.nextInt(100-55) + 55;
			myArray.add(num);
		}
		System.out.println(myArray.get(0)+" "+ myArray.get(myArray.size()-1));
		return myArray;
		
	}
	public void task5() {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder(5);
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		String output = sb.toString();
		System.out.println(output);
	}
	public void task6() {
		ArrayList<String> list = new ArrayList<String>();
		for(int a = 1; a <= 10; a++) {
		
			char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			StringBuilder sb = new StringBuilder(5);
			Random random = new Random();
			for (int i = 0; i < 5; i++) {
			    char c = chars[random.nextInt(chars.length)];
			    sb.append(c);
			}
			String output = sb.toString();
			list.add(output);
		}
		System.out.println(list);
		
	}
	
	
	

}
