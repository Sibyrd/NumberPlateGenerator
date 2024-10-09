package edu.theobird;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    public static JLabel platebox = new JLabel("");

    public static String generate() {
        File codesfile = new File("codes.json");
        Random rand = new Random();

        int year = rand.nextInt(9)+1;

        if (rand.nextInt(2) == 1) {
            year += (rand.nextInt(3)*10)+50;
        }
        DecimalFormat df = new DecimalFormat("00");
        String yearformatted = df.format(year);

        String code = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            HashMap map;
            map = objectMapper.readValue(codesfile, HashMap.class);

            code = (String) map.get(randomkey(Collections.unmodifiableMap(map)));

        } catch (IOException e) {
            e.printStackTrace();
        }

        //the three last letters
        String allowedLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".replace("I", "").replace("Q", "").replace("O", "");
        StringBuilder randletters = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            int index = rand.nextInt(allowedLetters.length());
            randletters.append(allowedLetters.charAt(index));
        }

        return code+yearformatted+" "+randletters;
    }

    public static String randomkey(Map<String, String> map){
        Random rand = new Random();
        Object[] keys = map.keySet().toArray();
        return keys[rand.nextInt(keys.length)].toString();
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Interface frame = new Interface();
    }
}