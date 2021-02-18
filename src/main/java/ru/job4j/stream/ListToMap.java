package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ListToMap {
    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();
        list.add(new Student(10, "Surname1"));
        list.add(new Student(20, "Surname2"));
        list.add(new Student(30, "Surname3"));

        Map<String, Student> map = list.stream()
                .distinct()
                .collect(Collectors.toMap(
                        Student::getSurname,
                        e -> e
                ));
    }

}
