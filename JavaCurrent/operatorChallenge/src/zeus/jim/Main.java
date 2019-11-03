package zeus.jim;

public class Main {

    public static void main(String[] args) {

//        step 1
        double myFirstDouble = 20.00;
//          step2
        double mysecondDouble = 80.00;
//        step3
        double addAndMult = (myFirstDouble +  mysecondDouble) * 100.00;
//        step 4
        double remainderOf = addAndMult % 40.00;
//        step 5
        boolean ifNoRemainder = (remainderOf == 0.00) ? true : false;
//        step 6
        System.out.println(ifNoRemainder);
//        step 7
        if(!ifNoRemainder){
            System.out.println("Got some remainder");
        }else{
            System.out.println("No remainder here");
        }


    }
}
