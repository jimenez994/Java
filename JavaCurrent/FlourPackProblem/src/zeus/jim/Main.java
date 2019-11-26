package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(canPack(3,1,13));
    }

    public static boolean canPack(int bigCount, int smallCount, int goal){
        if(bigCount >= 0 && smallCount >= 0 && goal >= 0){
            int sumOfBigCount = bigCount *5;
            if(goal % 5 != 0 && smallCount == 0){
                return false;
            }else if(goal % 5 == 0 && bigCount * 5 >= goal){
                return true;
            }else{
                if(goal / 5 <= bigCount && goal % 5 <= smallCount ){
                    return true;
                }else if (bigCount < goal/5 && goal % 5 < smallCount && sumOfBigCount + smallCount >= goal){
                    return true;
                }
            }
        }
        return false;
    }
}
