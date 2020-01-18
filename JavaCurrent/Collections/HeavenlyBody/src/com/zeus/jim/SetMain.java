package com.zeus.jim;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for(int i = 1; i <= 100; i++){
            squares.add(i*i);
            cubes.add(i*i*i);
        }
        System.out.println(" sqr Size: "+ squares.size() + " - " + "cubes Size:" + cubes.size());

        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);

        System.out.println("Union size: " + union.size());

//        getting only the elements that are the same
        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("Intersection size: " + intersection.size());
        System.out.println("intersections:");
        for (int num : intersection) {
            System.out.println(num);
        }

//        adding array elements
        Set<String> words = new HashSet<>();
        String sentence = "Why is lola crying by the door";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));
        for (String word: words) {
            System.out.println(word);
        }
    }
}
