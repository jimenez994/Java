/**
 * master
 */
// this is the main class 
public class master {

    public static void main(String args[]) throws InterruptedException{
        Thread.sleep(10000);
        System.out.println("this is a test");

        String str1 = "bla";
        String str2 = "bla";
        String str3 = new String("bla");
        System.out.println(str1 == str2);
    }
    
}