package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PaintTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOutput() {
        System.setOut(stdout);
    }

    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("+ + + +")
                                .append("\n")
                                .append("+     +")
                                .append("\n")
                                .append("+     +")
                                .append("\n")
                                .append("+ + + +")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenTriangleSquare() {
        new Paint().draw(new Triangle());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("    +    ")
                                .append("\n")
                                .append("  + + +  ")
                                .append("\n")
                                .append("+ + + + +")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}
