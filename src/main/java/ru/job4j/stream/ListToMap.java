package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {
    public static Map<String, Student> listToMap(List<Student> list) {
        return list.stream()
                .collect(Collectors.toMap(
                        Student::getSurname,
                        e -> e,
                        (st1, st2) -> st1.equals(st2) ? st1 : st2)
                );
    }
}
