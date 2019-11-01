package ru.job4j.sorting;

import java.util.*;

public class SortUser {
    public static Set<User> sort(List<User> users) {
        Set<User> result = new TreeSet<>();
        result.addAll(users);
        return result;
    }

    public static List<User> sortNameLength(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return (o1.getName().length() - o2.getName().length());
            }
        });
        return users;
    }

    public static List<User> sortByAllFields(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result = o1.getName().compareTo(o2.getName());
                return (result == 0) ? o1.getAge() - o2.getAge() : result;
            }
        });
        return users;
    }
}
