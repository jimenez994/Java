package zeus.jim;

public class Main {

    public static void main(String[] args) {

        int result = 1 + 2; // 1 + 2 = 3
        System.out.println(result);

        int complex = (3 + 4 )/2 + (4 -3) * 2;
        System.out.println(complex);

        int more = complex * result;
        System.out.println(more);

        int mod = more % 3;
        System.out.println(mod);

//        int
        int value = 5;
        value++; // 5 + 1 = 6
        value+=4;

        value--;
        value-=2;

        System.out.println(value);

        boolean personSick = true;

        if(personSick == false){
            System.out.println("The person is not sick");
        }else{
            System.out.println("The person is sick");
        }

        if(personSick)
            System.out.println("person is sick");

        int newValue = 50;

        if(newValue == 50){
            System.out.println("This is am error");
        }

        boolean isCar = true;

        if(!isCar){
            System.out.println("This is what?");
        }

        int clientAge = 20;

        boolean isEighteenOrOver = (clientAge >= 18) ? true : false;

        System.out.println("client is " + isEighteenOrOver);

        String isOver = (clientAge >= 18) ? "client is over 18" : "client is under age";

        System.out.println(isOver);
    }
}
