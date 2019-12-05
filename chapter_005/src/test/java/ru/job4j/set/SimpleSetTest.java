package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {
    SimpleSet<Integer> ss;
    @Before
    public void init() {
        ss = new SimpleSet<>();
    }

    @Test
    public void whenAddElementsTheyAreUnique() {
        ss.add(1);
        ss.add(2);
        ss.add(2);
        ss.add(3);
        ss.add(3);
        Iterator<Integer> ssIt = ss.iterator();
        assertThat(ssIt.next(), is(1));
        assertThat(ssIt.next(), is(2));
        assertThat(ssIt.next(), is(3));
        assertThat(ssIt.hasNext(), is(false));
    }
}
