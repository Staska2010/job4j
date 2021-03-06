package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                List.of(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when2ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                List.of(1, 2),
                9
        );
        int[][] expect = {
                {1}, {2}, {0}, {0}, {0}, {0}, {0}, {0}, {0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when6ElementsThen2() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                List.of(1, 2, 3, 4, 5, 6),
                2
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void whenConvertEvenListOfArray() {
        ConvertList2Array list = new ConvertList2Array();
        List<Integer> expected = new ArrayList<>();
        // Case #1
        expected.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> out = list.convert(List.of(
                new int[]{1, 2},
                new int[]{3, 4, 5, 6}));
        assertThat(out, is(expected));
        expected.clear();
        // Case #2
        expected.addAll(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        out = list.convert(List.of(
                new int[]{},
                new int[]{1, 2, 3, 4, 5, 6},
                new int[]{7},
                new int[]{8, 9}
                ));
        assertThat(out, is(expected));
    }
}
