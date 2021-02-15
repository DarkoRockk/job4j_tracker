package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] first = o1.split("/");
        String[] second = o2.split("/");
        int minLength = Math.min(first.length, second.length);
        for (int i = 0; i < minLength; i++) {
            if (i == 0) {
                int comp = second[i].compareTo(first[i]);
                if (comp != 0) {
                    return comp;
                }
            } else {
                int comp = first[i].compareTo(second[i]);
                if (comp != 0) {
                    return comp;
                }
            }
        }
        return first.length - second.length;
    }
}
