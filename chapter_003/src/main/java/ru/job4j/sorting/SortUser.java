package ru.job4j.sorting;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    public static Set<User> sort(List<User> users) {
        Set<User> result = new TreeSet<>();
        result.addAll(users);
        return result;
    }
}
