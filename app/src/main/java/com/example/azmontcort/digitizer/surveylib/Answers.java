package com.example.azmontcort.digitizer.surveylib;

import com.google.gson.Gson;


import java.util.LinkedHashMap;

//Singleton Answers ........

public class Answers {
    private volatile static Answers uniqueInstance;
    private final LinkedHashMap<String, String> answered_hashmap = new LinkedHashMap<>();


    private Answers() {
    }

    public void put_answer(String key, String value) {
        int length = key.length();
        String size = Integer.toString(length) ;
        answered_hashmap.put(size, value);
    }


    public String get_json_object() {
        Gson gson = new Gson();
        return gson.toJson(answered_hashmap,LinkedHashMap.class);
    }

    @Override
    public String toString() {
        return String.valueOf(answered_hashmap);
    }

    public static Answers getInstance() {
        if (uniqueInstance == null) {
            synchronized (Answers.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Answers();
                }
            }
        }
        return uniqueInstance;
    }
}
