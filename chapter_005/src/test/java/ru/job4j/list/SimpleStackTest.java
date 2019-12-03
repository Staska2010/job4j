package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleStackTest {
    SimpleStack<Integer> st;

    @Before
    public void init() {
        st = new SimpleStack<>();
    }

    @Test
    public void whenPush1And2ThenPop2And1() {
        st.push(1);
        st.push(2);
        Integer result = st.pop();
        assertThat(result, is(2));
        result = st.pop();
        assertThat(result, is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenTryToPopFromEmptyStackThenException() {
        st.push(1);
        st.push(2);
        st.pop();
        st.pop();
        st.pop();
    }

    @Test
    public void whenAlternatePushAndPop1And2Then2And1() {
        st.push(1);
        st.pop();
        st.push(2);
        assertThat(st.pop(), is(2));
    }
}
