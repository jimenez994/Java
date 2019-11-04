package zeus.jim;

public class Main {

    public static void main(String[] args) {

        printDayOfTheWeek(7);

        printDayOfTheWeekIf(2);

        printNumberInWord(2);

        int value = 6;

        switch (value){
            case 1:
                System.out.println("hi is 1");
                break;
            case 2:
                System.out.println("bla it was 2");
                break;
            case 3: case 4: case 5:
                System.out.println("it was 3 or 4 or 5");
                System.out.println("actually it was " + value);
                break;
            default:
                System.out.println("everything else");
                break;
        }

        char myChar = 'f';

        switch (myChar){
            case 'A':
                System.out.println("Your char was A");
                break;
            case 'B':
                System.out.println("actually it was B");
                break;
            case 'C':
                System.out.println("Your char is C");
                break;
            default:
                System.out.println("you char is not here");
                break;
        }

    }
    public static void printDayOfTheWeek(int value){
        switch (value){
            case 0:
                System.out.println("Sunday");
                break;
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5: System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Invalid day");
                break;
        }
    }

    public static void printDayOfTheWeekIf(int value){
        if (value == 0 ){
            System.out.println("Sunday");
        }else if( value == 1){
            System.out.println("Monday");
        }else if( value == 2){
            System.out.println("Tuesday");
        }else if( value == 3){
            System.out.println("Wednesday");
        }else if( value == 4){
            System.out.println("Thursday");
        }else if( value == 5){
            System.out.println("Friday");
        }else if( value == 6){
            System.out.println("Saturday");
        }else{
            System.out.println("Invalid day");
        }
    }

    public static void printNumberInWord(int value){
        switch (value){
            case 0:
                System.out.println("ZERO");
                break;
            case 1:
                System.out.println("ONE");
                break;
            case 2:
                System.out.println("TWO");
                break;
            case 3:
                System.out.println("THREE");
                break;
            case 4:
                System.out.println("FOUR");
                break;
            case 5:
                System.out.println("FIVE");
                break;
            case 6:
                System.out.println("SIX");
                break;
            case 7:
                System.out.println("SEVEN");
                break;
            case 8:
                System.out.println("EIGHT");
                break;
            case 9:
                System.out.println("NINE");
                break;
            default:
                System.out.println("OTHER");
                break;
        }
    }
}
