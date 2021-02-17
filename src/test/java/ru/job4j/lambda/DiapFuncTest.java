package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DiapFuncTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        DiapFunc function = new DiapFunc();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenQuadroResults() {
        DiapFunc function = new DiapFunc();
        List<Double> result = function.diapason(5, 8, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenPokResults() {
        DiapFunc function = new DiapFunc();
        List<Double> result = function.diapason(1, 3, x -> Math.pow(4, x));
        List<Double> expected = Arrays.asList(4D, 16D);
        assertThat(result, is(expected));
    }
}