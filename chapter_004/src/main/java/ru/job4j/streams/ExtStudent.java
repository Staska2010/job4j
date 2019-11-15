package ru.job4j.streams;

/**
 * Decorator for Student class.
 * New behaviour added - methods for surname processing
 * to avoid breaking of existing code.
 */
public class ExtStudent {
    private Student student;
    private String surname;

    public ExtStudent(Student student, String surname) {
        this.student = student;
        this.surname = surname;
    }

    public String getSurname() {
        return this.surname;
    }

    public int getScore() {
        return student.getScore();
    }
}
