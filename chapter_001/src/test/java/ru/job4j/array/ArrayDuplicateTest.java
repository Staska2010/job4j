package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class ArrayDuplicateTest {
    @Test
    public void whenThereAreDublicatesFormattedArray() {
        ArrayDuplicate ardup = new ArrayDuplicate();
        String[] in = new String[]{"moscow", "world", "world", "berlin", "moscow", "madrid", "paris", "berlin", "lenin"};
        String[] expected = new String[]{"moscow", "world", "berlin", "paris", "lenin", "madrid"};
        String[] out = ardup.remove(in);
        Assert.assertThat(expected, is(out));
    }

    @Test
    public void whenNoDublicatesTheSameArray() {
        ArrayDuplicate ardup = new ArrayDuplicate();
        String[] in = new String[]{"moscow", "world", "berlin", "madrid", "paris"};
        String[] expected = new String[]{"moscow", "world", "berlin", "madrid", "paris"};
        String[] out = ardup.remove(in);
        Assert.assertThat(expected, is(out));
    }
}
