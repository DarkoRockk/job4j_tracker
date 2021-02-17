package ru.job4j.collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Article {

    public static boolean generateBy(String origin, String line) {
        String origin1 = origin.replaceAll("\\p{Punct}", "");
        String line1 = line.replaceAll("\\p{Punct}", "");
        String[] text1 = origin1.split(" ");
        String[] text2 = line1.split(" ");
        Set<String> words = new HashSet<>();
        Collections.addAll(words, text1);
        for (String text : text2) {
            if (!words.contains(text)) {
                return false;
            }
        }
        return true;
    }
}
