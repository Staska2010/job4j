package ru.job4j.tracker;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import static org.hamcrest.core.Is.is;


public class ValidateInputTest {

    @Test
    public void whenUserEnterNonDigitDataThenRepeatInput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ValidateInput input = new ValidateInput(new StubInput(new ArrayList<String>(Arrays.asList(new String[]{"asf", "1"})) ));
        input.askInt("Enter", 2);
        String trackerOutput = out.toString();
        String expected = new StringBuilder("Повторите ввод").append(System.lineSeparator()).toString();
        Assert.assertThat(trackerOutput, is(expected));
        System.setOut(System.out);
    }

    @Test
    public void whenUserEnterWrongNumberThenChooseValidMenu() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ValidateInput input = new ValidateInput(new StubInput(new ArrayList<String>(Arrays.asList(new String[]{"5", "1"}))));
        input.askInt("Enter", 2);
        String trackerOutput = out.toString();
        String expected = new StringBuilder("Выберите правильный пункт меню").append(System.lineSeparator()).toString();
        Assert.assertThat(trackerOutput, is(expected));
        System.setOut(System.out);
    }

}
