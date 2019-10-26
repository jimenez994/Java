package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("******************** int *********************");
        //Primitive data for int
        int value = 10000;
        int minIntValue = Integer.MIN_VALUE;
        int maxIntValue = Integer.MAX_VALUE;

//        An int has a max of 2147483647 and minimum of -2147483647
        System.out.println("Min in int is " + minIntValue + " max is " + maxIntValue);
        int otherWay = 2_344_344;
        System.out.println(otherWay);
        System.out.println("This is an exmple of a int = " + value);

        /* Byte */
        System.out.println("********************* byte ********************");
        byte byteValue = 122;
        byte maxByteNum = Byte.MAX_VALUE;
        byte minByteNum = Byte.MIN_VALUE;
        System.out.println("This is an example of a a byte = " + byteValue);
        System.out.println("Min value of a Byte is " + minByteNum +" and a Max number of " + maxByteNum );

        /* Short */
        System.out.println("********************* short ********************");
        short shortValue = 1262;
        short maxShortNum = Short.MAX_VALUE;
        short minShortNum = Short.MIN_VALUE;
        System.out.println("This is an example of a a short = " + shortValue);
        System.out.println("Min value of a Short is " + minShortNum +" and a Max number of " + maxShortNum );
        
        /* Long */
        System.out.println("********************* long ********************");
//        reminder L at the end to tell the computer is a long value
        long longValue = 1262L;
        long maxLongNum = Long.MAX_VALUE;
        long minLongNum = Long.MIN_VALUE;
        System.out.println("This is an example of a a long = " + longValue);
        System.out.println("Min value of a Long is " + minLongNum +" and a Max number of " + maxLongNum );

//      A little Challenge
        byte byteNum = 43;
        short shortNum = 432;
        int intNum  = 6453;
//        this doesn't need to cast since long a int work well together
        long longNum = (50000L + (10L * (byteNum + intNum + shortNum)));
        System.out.println("result is : "+ longNum);
    }
}
