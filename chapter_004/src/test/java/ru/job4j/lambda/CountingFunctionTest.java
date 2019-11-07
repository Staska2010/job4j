package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class CountingFunctionTest {

    @Test
    public void whenLinearFunctionThenLinearData() {
        CountingFunction function = new CountingFunction();
        List<Double> result = function.diapason(0, 5, (x) -> 2 * x + 1);
        List<Double> expected = Arrays.asList(1D, 3D, 5D, 7D, 9D, 11D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticData() {
        CountingFunction function = new CountingFunction();
        List<Double> result = function.diapason(0, 5, (x) -> x * x + 2);
        List<Double> expected = Arrays.asList(2D, 3D, 6D, 11D, 18D, 27D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunctionThenLogarithmicData() {
        CountingFunction function = new CountingFunction();
        List<Double> result = function.diapason(1, 3, (x) -> 2 * Math.log(x) + 1);
        assertEquals(result.get(0), 1D, 0.01);
        assertEquals(result.get(1), 2.39D, 0.01);
        assertEquals(result.get(2), 3.20D, 0.01);
    }
}