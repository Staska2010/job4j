package ru.job4j.calculator;

import org.junit.Assert;
import org.junit.Test;

public class FitTest {
    @Test
    public void mainWeight() {
        double in = 176;
        double expected = 87.4;
        double out = Fit.manWeight(176);
        Assert.assertEquals(expected,out, 0.01);
    }
}
