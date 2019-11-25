package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {
    @Test
    public void whenAddNewModels() {
        SimpleArray<Integer> sa = new SimpleArray<>(10);
        sa.add(1);
        sa.add(2);
        sa.add(3);
        assertThat(sa.get(0), is(1));
        assertThat(sa.get(1), is(2));
        assertThat(sa.get(2), is(3));
    }

    @Test
    public void whenRemoveModelElementsShiftsLeft() {
        SimpleArray<Integer> sa = new SimpleArray<>(10);
        sa.add(1);
        sa.add(2);
        sa.add(3);
        sa.remove(1);
        assertThat(sa.get(1), is(3));
        assertNull(sa.get(3));
    }

    @Test
    public void whenUseIteratorItWorksCorrectly() {
        SimpleArray<Integer> sa = new SimpleArray<>(10);
        sa.add(1);
        sa.add(2);
        sa.add(3);
        Iterator saIt = sa.iterator();
        assertThat(saIt.hasNext(), is(true));
        assertThat(saIt.next(), is(1));
        assertThat(saIt.hasNext(), is(true));
        assertThat(saIt.next(), is(2));
        assertThat(saIt.hasNext(), is(true));
        assertThat(saIt.next(), is(3));
        assertThat(saIt.hasNext(), is(false));
    }

    @Test
    public void whenUseIteratorAndRemoveElementItWorksCorrectly() {
        SimpleArray<Integer> sa = new SimpleArray<>(10);
        sa.add(1);
        sa.add(2);
        sa.add(3);
        sa.remove(1);
        Iterator saIt = sa.iterator();
        assertThat(saIt.hasNext(), is(true));
        assertThat(saIt.next(), is(1));
        assertThat(saIt.hasNext(), is(true));
        assertThat(saIt.next(), is(3));
        assertThat(saIt.hasNext(), is(false));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenTryToAddMoreElementsTheArrayCapacityThenException() {
        SimpleArray<Integer> sa = new SimpleArray<>(3);
        sa.add(1);
        sa.add(2);
        sa.add(3);
        sa.add(4);
    }
}
