package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(reverse(123));
        System.out.println(getDigitCount(5200));
        numberToWords(123456789);
    }
    public static void numberToWords(int number){
        if(number < 0){
            System.out.println("Invalid Value");
        }else{
            int numInReverse = reverse(number);
            int digitCount = getDigitCount(number);
            while (digitCount > 0){
                int singleNumber = numInReverse % 10;
                numInReverse /= 10;
                digitCount--;
                switch (singleNumber){
                    case 1:
                        System.out.println("One");
                        break;
                    case 2:
                        System.out.println("Two");
                        break;
                    case 3:
                        System.out.println("Three");
                        break;
                    case 4:
                        System.out.println("Four");
                        break;
                    case 5:
                        System.out.println("Five");
                        break;
                    case 6:
                        System.out.println("Six");
                        break;
                    case 7:
                        System.out.println("Seven");
                        break;
                    case 8:
                        System.out.println("Eight");
                        break;
                    case 9:
                        System.out.println("Nine");
                        break;
                    default:
                        System.out.println("Zero");
                        break;
                }
            }
        }
    }
    public static int reverse(int number){
        int originalNum = number;
        int newNum = 0;
        int holder = 0;
        boolean ifNegative = false;
        if (number < 0){
            ifNegative = true;
            originalNum *= (-1);
            System.out.println(newNum);
        }
        while (originalNum > 0){
            holder = (originalNum % 10);
            newNum *= 10;
            newNum += holder;
            originalNum = originalNum /10;
        }

        return ifNegative ? (newNum *= -1) : newNum;
    }

    public static int getDigitCount(int number){
        if(number >= 0){
            int count = 0;
            while (number > 0){
                count++;
                number = number/10;
            }
            return count > 0 ? count: 1;
        }

        return -1;
    }


}
