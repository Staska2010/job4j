package ru.job4j.sorting;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

import java.util.*;

public class SortUserTest {
    @Test
    public void whenSortDataSetThenSorted() {
        Set<User> expected = new HashSet<>(Arrays.asList(new User("User3", 10),
                                                        new User("User2", 20),
                                                        new User("User1", 30)));
        Set<User> result = SortUser.sort(Arrays.asList(
                                                        new User("User1", 30),
                                                        new User("User2", 20),
                                                        new User("User3", 10)));
        Assert.assertThat(result, is(expected));
    }
}