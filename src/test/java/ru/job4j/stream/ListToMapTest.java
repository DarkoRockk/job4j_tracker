package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ListToMapTest {

    @Test
    public void listToMaptest() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(10, "Surname1"));
        list.add(new Student(20, "Surname2"));
        list.add(new Student(30, "Surname3"));
        list.add(new Student(30, "Surname3"));
        Map<String, Student> map = ListToMap.listToMap(list);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Surname1", new Student(10, "Surname1"));
        expected.put("Surname2", new Student(20, "Surname2"));
        expected.put("Surname3", new Student(30, "Surname3"));
        assertThat(map, is(expected));
    }

}