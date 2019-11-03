package zeus.jim;

public class Main {

    public static void main(String[] args) {

        char myChar = 'D';
        char unicodeChar = 'Ϩ';
        char unicodeCharU = '\u03E8';

        System.out.println(myChar);
        System.out.println(unicodeChar + "  -> this in unicode " + unicodeCharU);

        boolean myTrueBooleanValue = true;
        boolean myFalseBooleanValue = false;

        System.out.println(myFalseBooleanValue  + "  " + myTrueBooleanValue);

//        public void changeMyTrue(){
//
//        };

        if (myFalseBooleanValue ==! myTrueBooleanValue) {
            System.out.println("my true false statement is not a true statement");
        }else{
            System.out.println("my true statement become a false statement");
        }


    }


}
