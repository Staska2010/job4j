package ru.job4j.student;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class StudentTest {
    StudentStore store = new StudentStore();
    List<Student> students = new ArrayList<>();
    Student student1 = new Student("Name1", 10);
    Student student2 = new Student("Name2", 20);
    Student student3 = new Student("Name3", 30);
    Student student4 = new Student("Name4", 40);
    Student student5 = new Student("Name5", 50);

    @After
    public void onExit() {
        students.clear();
    }

    @Test
    public void whenFilterByScopeThenFilteredList() {
        students.addAll(List.of(
                student1,
                student2,
                student3,
                student4,
                student5
        ));
        students.add(2, null);
        students.add(4, null);
        List<Student> actual = store.levelOf(students, 20);
        List<Student> expected = List.of(student5, student4, student3);
        assertThat(actual, is(expected));
    }

    @Test
    public void whenThereAreNotSuchStudentsThenEmptyList() {
        students.addAll(List.of(
                student1,
                student2,
                student3,
                student4
        ));
        students.add(2, null);
        students.add(4, null);
        List<Student> actual = store.levelOf(students, 40);
        List expected = Collections.EMPTY_LIST;
        assertThat(actual, is(expected));
    }

    @Test
    public void whenJustNullsThenEmptyList() {
        students.add(null);
        students.add(null);
        students.add(null);
        students.add(null);
        List<Student> actual = store.levelOf(students, 20);
        List expected = Collections.EMPTY_LIST;
        assertThat(actual, is(expected));
    }
}