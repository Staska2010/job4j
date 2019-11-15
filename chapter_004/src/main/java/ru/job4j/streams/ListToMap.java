package ru.job4j.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {
    public Map<String, ExtStudent> convert(List<ExtStudent> students) {
        return students.stream()
                        .distinct()
                        .collect(Collectors.toMap(s -> s.getSurname(), s -> s));
    }
}
