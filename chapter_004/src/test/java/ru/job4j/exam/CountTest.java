package ru.job4j.exam;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class CountTest {
    @Test
    public void whenEmptyListThen0() {
        Count testCount = new Count();
        Integer actual = testCount.count(Collections.EMPTY_LIST);
        Integer expected = 0;
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void when12345Then20() {
        Count testCount = new Count();
        Integer actual = testCount.count(List.of(1, 2, 3, 4, 5));
        Integer expected = 20;
        Assert.assertThat(actual, is(expected));
    }


    @Test
    public void when135Then0() {
        Count testCount = new Count();
        Integer actual = testCount.count(List.of(1, 3, 5));
        Integer expected = 0;
        Assert.assertThat(actual, is(expected));
    }
}
