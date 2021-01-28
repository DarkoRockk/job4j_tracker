package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class MaxTest {

    @Test
    public void maxTwoNumbers() {
        int result = Max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void maxTreeNumbers() {
        int result = Max.max(1, 2, 3);
        assertThat(result, is(3));
    }

    @Test
    public void maxFourNumbers() {
        int result = Max.max(1, 4, 3, 2);
        assertThat(result, is(4));
    }
}