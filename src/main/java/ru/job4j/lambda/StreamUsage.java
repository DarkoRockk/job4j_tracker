package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = -10; i < 10; i++) {
            list.add(i);
        }
        List<Integer> positive = list.stream().filter(
                numb -> numb > 0
        ).collect(Collectors.toList());

        System.out.println(positive.toString());
    }
}
