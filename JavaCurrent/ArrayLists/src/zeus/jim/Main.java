package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] numist = {1,2,3,4,5,6,7};
        numist[0]= 8;
        for (int num: numist) {
            System.out.println(num);
        }
        int[] numList2 = new int[5];
        numList2[4] = 4;
        numList2[3] = 5;
        for (int item: numList2) {
            System.out.println(item);
        }

        double[] doubleList= new double[2];
        doubleList[0] = 3.4;
        for (double du: doubleList
             ) {
            System.out.println("some double -->"+ du);
        }
    }
}
