package ru.job4j.student;

public class Student implements Comparable<Student> {
    private String name;
    private int scope;

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public int getScope() {
        return scope;
    }

    @Override
    public int compareTo(Student st) {
        return (this.scope - st.scope);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
