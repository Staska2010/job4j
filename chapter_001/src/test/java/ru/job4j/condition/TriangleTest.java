package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenExist() {
        Point ap = new Point(0, 0);
        Point bp = new Point(3, 3);
        Point cp = new Point(6, 0);
        Triangle triangle = new Triangle(ap, bp, cp);
        double result = triangle.area();
        double expected = 9.0;
        Assert.assertEquals(expected, result, 0.01);
    }
}