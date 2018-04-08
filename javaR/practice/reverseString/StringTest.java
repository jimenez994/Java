/**
 * String
 */
public class StringTest{

    public static void main(String[] args){

        String x = "hola";
        String str1 = "Abracadabra";
        // String xp = reverseStr(x);
        String xp2 = rv2(x);
        System.out.println(xp2);
        System.out.println(isPrime(11));
        System.out.println(8 %10);
        System.out.println(reverseNum(345));
    }
    //    reverse String 1
    public static String reverseStr(String str) {
        return new StringBuilder(str).reverse().toString();
    } 
    // reverse String 2
    public static String rv2(String str){
        StringBuilder newStr = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            newStr = newStr.append(str.charAt(str.length()-i-1));
        }
        return newStr.toString();
    }
    // is prime
    public static String isPrime(int num){
        if (num == 0 || num == 1){
            return "is not prime";
        }
        if(num == 2){
            return "is prime";
        }
        for(int i = 2; i < num/2; i++){
            if(num % i ==0){
                System.out.println(i);
                return "is not prime";
            }
        }
        return "is prime";
    }
    // reverse Number
    public static int reverseNum(int num){
        int newNum = 0;
        while(num != 0){
            newNum = (newNum * 10) + (num % 10);
            num = num/10;
        }
        return newNum;
    }
    
}