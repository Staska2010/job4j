package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class SqMaxTest {
    @Test
    public void whenCompare1234Then4() {
        int result = SqMax.max(1, 2, 3, 4);
        assertThat(result, is(4));
    }

    @Test
    public void whenCompare4321Then4() {
        int result = SqMax.max(4, 3, 2, 1);
        assertThat(result, is(4));
    }

    @Test
    public void whenCompare3421Then4() {
        int result = SqMax.max(3, 4, 2, 1);
        assertThat(result, is(4));
    }

    @Test
    public void whenCompare3241Then4() {
        int result = SqMax.max(3, 2, 4, 1);
        assertThat(result, is(4));
    }

    @Test
    public void whenCompare1324Then4() {
        int result = SqMax.max(1, 3, 2, 4);
        assertThat(result, is(4));
    }
}
