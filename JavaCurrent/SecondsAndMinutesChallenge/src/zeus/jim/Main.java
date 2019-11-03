package zeus.jim;

public class Main {

    private static final String INVALID_VALUE_MESSAGE = "Invalid value";

    public static void main(String[] args) {
        getDurationString(1515, 145);
        getDurationString(25814);

        area(5);
        area(7,4);

        printYearsAndDays(561600);

        printEqual(-1,-1,-1);
        printEqual(1,2,3);
        printEqual(1,2,1);
        printEqual(1,1,1);

        System.out.println(isCatPlaying(true, 10));
        System.out.println(isCatPlaying(false, 36));
        System.out.println(isCatPlaying(false, 35));

    }
    public static String getDurationString(int minutes, int seconds){
        if(minutes >= 0 && seconds >= 0 && seconds <=59){
            int totalHours = minutes/60;
            System.out.println(totalHours +"h " +  minutes % 60 + "m " + seconds +"s");
            return totalHours +"h " +  minutes % 60 + "m " + seconds +"s";
        }
        System.out.println(INVALID_VALUE_MESSAGE);
        return INVALID_VALUE_MESSAGE;
    }
    public static String getDurationString( int seconds){
        if(seconds >= 0 ){
            return getDurationString((int)seconds/60, seconds % 60);
        }
        return INVALID_VALUE_MESSAGE;
    }

    public static double area(double radious){
        if(radious >= 0 ){
            System.out.println(Math.PI * (Math.pow(radious, 2)));
            return Math.PI * (Math.pow(radious, 2));
        }
        return -1.0;
    }
    public static double area(double x, double y){
        if(x >= 0 && y >= 0){
            return x * y;
        }
        return -1.0;
    }

    public static void printYearsAndDays(long minutes){
        if(minutes >= 0){
            long hours = minutes/60;
            long days = hours/24;
            long years = days/365;
            System.out.println(minutes + " min " + years + " y and " + days % 365 + " d");
        }else{
            System.out.println("Invalid Value");
        }
    }

    public static void printEqual(int value1, int value2, int value3){
        if(value1 < 0 || value2 < 0 || value3 < 0){
            System.out.println("Invalid Value");
        }else{
            if(value1 ==  value2 && value2 == value3){
                System.out.println("All numbers are equal");
            }else if( value1 != value2 && value2 != value3 && value3 != value1 ){
                System.out.println("All numbers are different");
            }else{
                System.out.println("Neither all are equal or different");
            }
        }
    }

    public static boolean isCatPlaying(boolean summer, int temperature){
        if(summer && temperature >= 25 && temperature <= 45 ){
            return true;
        }else if(!summer && temperature >= 25 && temperature <= 35){
            return true;
        }else{
            return false;
        }
    }


}