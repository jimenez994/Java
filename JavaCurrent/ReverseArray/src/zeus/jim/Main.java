package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] myList = {1,2,3,4,5,6,7,8};
        int[] reverseArr = reverse(myList);
        print(reverseArr);
        print(myList);
    }
    public static int[] reverse(int[] myArr){
        int[] revArr = new int[myArr.length];
        for (int i = 0; i <= myArr.length/2; i++){
            revArr[i] = myArr[myArr.length - i - 1];
            revArr[myArr.length - i - 1] = myArr[i];
        }
        return revArr;
    }

    public static void print(int[] inArray){
        String toString = "[";
        for (int i = 0; i < inArray.length; i++){
            if(i == inArray.length-1){
                toString += (inArray[i] +"]");
            }else{
                toString += (inArray[i] +",");
            }
        }
        System.out.println(toString);
    }
}
