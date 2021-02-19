package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixToListTest {

    @Test
    public void mtlTest() {
        Integer[][] matrix = {{1, 2}, {3, 4}};
        List<Integer> list = MatrixToList.mtl(matrix);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        assertThat(list, is(expected));
    }

}