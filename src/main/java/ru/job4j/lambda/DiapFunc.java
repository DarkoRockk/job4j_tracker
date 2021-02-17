package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DiapFunc {

    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (; start < end; start++) {
            Double apply = func.apply((double) start);
            result.add(apply);
        }
        return result;
    };
}
