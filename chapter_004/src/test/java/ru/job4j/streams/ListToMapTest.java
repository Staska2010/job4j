package ru.job4j.streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;

public class ListToMapTest {
    @Test
    public void whenConvertListThenGetMap() {
        ListToMap converter = new ListToMap();
        ExtStudent st1 = new ExtStudent(new Student(10), "Surname1");
        ExtStudent st2 = new ExtStudent(new Student(20), "Surname2");
        ExtStudent st3 = new ExtStudent(new Student(30), "Surname3");
        Map<String, ExtStudent> actual = converter.convert(List.of(st1, st2, st3));
        Map<String, ExtStudent> expected = Map.of(
                "Surname1", st1,
                "Surname2", st2,
                "Surname3", st3
        );
        Assert.assertThat(actual, is(expected));
    }
}
