package ru.job4j.sorting;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

import java.util.*;

public class SortUserTest {
    @Test
    public void whenSortDataSetThenSorted() {
        Set<User> expected = new LinkedHashSet<>(Arrays.asList(new User("User3", 10),
                                                        new User("User2", 20),
                                                        new User("User1", 30)));
        Set<User> result = SortUser.sort(Arrays.asList(
                                                        new User("User1", 30),
                                                        new User("User2", 20),
                                                        new User("User3", 10)));
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenSortByNameLengthThenSorted() {
        List<User> expected = new ArrayList<>(Arrays.asList(new User("UserA", 30),
                new User("UserAB", 20),
                new User("UserABC", 10)));
        List<User> result = SortUser.sortNameLength(Arrays.asList(
                new User("UserAB", 20),
                new User("UserABC", 10),
                new User("UserA", 30)));
        Assert.assertThat(result, is(expected));
    }

    @Test
    public void whenSortByAllFiedsThenSorted() {
        List<User> expected = new ArrayList<>(Arrays.asList(new User("Ivan", 25),
                new User("Ivan", 30),
                new User("Sergey", 20),
                new User("Sergey", 25)));
        List<User> result = SortUser.sortByAllFields(Arrays.asList(
                new User("Sergey", 25),
                new User("Ivan", 30),
                new User("Sergey", 20),
                new User("Ivan", 25)));
        Assert.assertThat(result, is(expected));
    }
}