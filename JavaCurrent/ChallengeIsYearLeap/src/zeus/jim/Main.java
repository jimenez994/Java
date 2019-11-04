package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(isLeapYear(2000));
        System.out.println(getDaysInMonth(2,2018));
    }

    public static boolean isLeapYear(int year){
        if(year >= 1 && year <=9999 ){
            if(year % 4 == 0 &&  year % 100 != 0 || year % 400 == 0){
                return true;
            }
            return false;
        }
        return false;
    }
    public static int getDaysInMonth(int month, int year){
        if(month > 0 && month < 13 && year > 0 && year < 10000 ){
            boolean isALeapYear = isLeapYear(year);
            switch (month){
//                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
//                    return 31;
                case 4: case 6: case 9: case 11:
                    return 30;
                case 2:
                    if(isALeapYear){
                        return 29;
                    }else{
                        return 28;
                    }
                default:
                    return 31;
            }
        }
        return -1;
    }
}
