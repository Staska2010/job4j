package ru.job4j.exam;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class MachineTest {
    @Test
    public void whenEquals() {
        Machine machine = new Machine();
        int[] expected = {};
        int[] rsl = machine.change(100, 100);
        assertThat(rsl, is(expected));
    }

    @Test
    public void when50by35() {
        Machine machine = new Machine();
        int[] expected = {10, 5};
        int[] rsl = machine.change(50, 35);
        assertThat(rsl, is(expected));
    }

    @Test
    public void when10by1() {
        Machine machine = new Machine();
        int[] expected = {5, 2, 2};
        int[] rsl = machine.change(10, 1);
        assertThat(rsl, is(expected));
    }

    @Test
    public void when10by7() {
        Machine machine = new Machine();
        int[] expected = {2, 1};
        int[] rsl = machine.change(10, 7);
        assertThat(rsl, is(expected));
    }
}
