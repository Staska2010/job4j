package ru.job4j.converter;

import org.junit.Assert;
import org.junit.Test;

public class ConverterTest {
    @Test
    public void RubleToEuro() {
        int in = 140;
        int expected = 2;
        int out = Converter.rubleToEuro(140);
        Assert.assertEquals(expected, out);
    }
    @Test
    public void RubleToDollar() {
        int in = 130;
        int expected = 2;
        int out = Converter.rubleToDollar(130);
        Assert.assertEquals(expected, out);
    }
}
