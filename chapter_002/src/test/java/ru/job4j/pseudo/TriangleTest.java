package ru.job4j.pseudo;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        Shape triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("    +    ")
                                .append("\n")
                                .append("  + + +  ")
                                .append("\n")
                                .append("+ + + + +")
                                .toString()
                )
        );
    }
}
