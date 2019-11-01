package ru.job4j.sorting;

public class User implements Comparable<User> {
    private String name;
    private int age;

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User userCompare) {
        return  this.age - userCompare.age;
    }
}
