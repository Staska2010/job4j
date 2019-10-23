package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person iterator : this.persons) {
            if (iterator.getAddress().contains(key) ||
                iterator.getName().contains(key) ||
                iterator.getPhone().contains(key) ||
                iterator.getSurname().contains(key)) {
                result.add(iterator);
            }
        }
        return result;
    }
}