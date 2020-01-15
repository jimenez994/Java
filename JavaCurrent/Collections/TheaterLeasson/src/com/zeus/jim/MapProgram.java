package com.zeus.jim;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();

        languages.put("Java", "s about java ");
        languages.put("Ja", "someg about java ");
        languages.put("a", "something t java ");
        languages.put("python", "something about java ");
        languages.put("js", "something about j ");
        languages.put("ghtml", "soing about java ");
        languages.put("css", "somethinut java ");
        languages.put("Jger", "something abouva ");
        languages.put("rga", "sometout java ");

//        languages.forEach();

        for (String key: languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }
    }
}
