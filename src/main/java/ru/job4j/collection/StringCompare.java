package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
       int length = Math.min(left.length(), right.length());
       for (int i = 0; i < length; i++) {
           char a = left.charAt(i);
           char b = right.charAt(i);
           if (a != b) {
               return a - b;
           }
       }
       return left.length() - right.length();
    }
}
