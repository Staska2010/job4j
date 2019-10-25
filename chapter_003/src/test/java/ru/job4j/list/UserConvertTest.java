package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserConvertTest {
    @Test
    public void whenConvertListThenMap() {
        UserConvert converter = new UserConvert();
        List<User> users = new ArrayList<User>();
        User user1 = new User(1, "name1", "city1");
        User user2 = new User(2, "name2", "city2");
        User user3 = new User(3, "name3", "city3");
        users.addAll(Arrays.asList(user1, user2, user3));
        HashMap<Integer, User> result = converter.process(users);
        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(1, user1);
        expected.put(2, user2);
        expected.put(3, user3);
        assertThat(result, is(expected));

    }
}

