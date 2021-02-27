package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {

    private List<Integer> list;

    public static EasyStream of(List<Integer> source) {
        EasyStream stream = new EasyStream();
        stream.list = source;
        return stream;
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        for (Integer num : this.list) {
            rsl.add(fun.apply(num));
        }
        this.list = rsl;
        return this;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        for (Integer num : this.list) {
            if (fun.test(num)) {
                rsl.add(num);
            }
        }
        this.list = rsl;
        return this;
    }

    public List<Integer> collect() {
        return this.list;
    }
}
