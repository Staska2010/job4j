package ru.job4j.streams;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

import java.util.Collections;
import java.util.List;

public class MatrixToListTest {
    @Test
    public void whenConvertMatrixToListThenList() {
        MatrixToList testConvert = new MatrixToList();
        List<Integer> actual = testConvert.collect(new Integer[][] {
                                                        {1, 2, 3},
                                                        {4, 5, 6},
                                                        {7, 8, 9}
        });
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Assert.assertThat(actual, is(expected));
    }
}
