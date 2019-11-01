package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

/**
 * Converting list of users to Map
 *
 * @author SKlokov
 */
public class UserConvert {
    /**
     * @param list - list for converting to HasMap
     * @return HashMap<Integer, User>
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User iterator : list) {
            result.put(iterator.getId(), iterator);
        }
        return result;
    }
}
