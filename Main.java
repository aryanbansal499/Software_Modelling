package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public  static void main(String[] args) throws FileNotFoundException {
        // write your code here
        Scanner sc1 = new Scanner(System.in);
        String fileName = sc1.next();
        File file =
                new File("src/" + fileName);
        Scanner sc = new Scanner(file);

        String unclean = "";
        while (sc.hasNext()) {
            unclean = unclean + " " + sc.next();
        }
        String[] cleaned = unclean.replaceAll("[^a-zA-Z]", " ").toLowerCase().trim().replaceAll(" +", " ").split(" ");
        alterMap(cleaned);
    }

    public static void alterMap(String[] cleaned) {

        HashMap<String,Integer> map = new HashMap<String, Integer>();

        int count = 0;
        for (int i = 0; i< cleaned.length;i++){
            map.put(cleaned[i],count);
        }
        for (String word : cleaned) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            }
            else {
                map.put(word, 1);
            }
        }
        for (String word : map.keySet()){

            String key = word;
            int value = map.get(word);
            System.out.println(key + " " + value);
            }
        System.exit(0);
    }


}

