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
    }
       
    public static String reverseStr(String str) {
        return new StringBuilder(str).reverse().toString();
    } 
    public static String rv2(String str){
        StringBuilder newStr = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            newStr = newStr.append(str.charAt(str.length()-i-1));
        }
        return newStr.toString();
    }
    
}