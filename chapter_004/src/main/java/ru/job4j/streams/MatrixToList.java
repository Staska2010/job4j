package ru.job4j.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixToList {
    public List<Integer> collect(Integer[][] array) {
        return Arrays.stream(array).
                flatMap(s -> Arrays.stream(s)).
                collect(Collectors.toList());
    }
}
