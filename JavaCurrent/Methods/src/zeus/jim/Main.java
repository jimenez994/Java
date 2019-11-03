package zeus.jim;

public class Main {

    public static void main(String[] args) {
        String name = "john";
        int score = 800;
        int levelCompleted = 5;
        displayHighScorePosition(name, score);
        System.out.println(calculateScorePosition(score));

        toMilesPerHour(25.42);

        printMegaBytesAndKiloBytes(2500);

        System.out.println(shouldWakeUp(true, 23));
        System.out.println(shouldWakeUp(false, 2));
        System.out.println(shouldWakeUp(true, 8));
        System.out.println(shouldWakeUp(true, -1));

        System.out.println(isLeapYear(1924));

        areEqualByThreeDecimalPlaces(-2.34543, -23.5656);

    }

    private static  void displayHighScorePosition(String name, int score){
        System.out.println(name + " Managed to get into position " + score);
    }

    private static int calculateScorePosition(int score){
        if(score >= 1000){
            return 1;
        }else if(score >= 500){
            return 2;
        }else if(score >= 100){
            return  3;
        }else {
            return 4;
        }
    }
    public static long toMilesPerHour(double kilometersPerHour){
        if(kilometersPerHour < 0){
            return -1;
        }
        long milesPerHour = (Long) Math.round(kilometersPerHour / 1.609);
        System.out.println(milesPerHour);
        return milesPerHour;

    }

    public static void printMegaBytesAndKiloBytes(int kiloBytes){
        if(kiloBytes < 0){
            System.out.println("Invalid Value");
        }else{

            System.out.println(kiloBytes + " KB = " + kiloBytes/1024 + "MB and " + kiloBytes % 1024 + " KB");
        }
    }

    public static boolean shouldWakeUp(boolean barking, int hourOfDay){
        if(hourOfDay >= 0 && hourOfDay <= 23 ){
            if(barking && hourOfDay < 8 || hourOfDay > 22){
                return true;
            }else if(!barking){
                return false;
            }else if(barking && hourOfDay > 8){
                return false;
            }
        }
        return false;
    }

    public static boolean isLeapYear(int year){
        if(year >= 1 && year <= 9999){
            if(year % 4 == 0){
                if(year % 100 == 0){
                    if(year % 400 == 0){
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    return true;
                }
            }else{
                return false;
            }
        }
        return false;
    }

    public static boolean areEqualByThreeDecimalPlaces( double num1,  double num2){
//        float flostnu = (float) num1;
        System.out.println("  "+ (int)(num2*1000));
        if((int)(num1*1000) == (int)(num2*1000)){

            return true;
        }
        return false;
    }

    public static boolean hasEqualSum(int num1, int num2, int num3){
        if((num1) + (num2 ) == (num3)){
                return true;
        }
        return false;
    }


}
