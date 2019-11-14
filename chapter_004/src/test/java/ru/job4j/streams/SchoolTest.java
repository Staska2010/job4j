package ru.job4j.streams;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;

public class SchoolTest {
    School testSchool = new School();
    List<Student> students = new ArrayList<>();

    @Before
    public void init() {
        Student student1 = new Student(10);
        Student student2 = new Student(20);
        Student student3 = new Student(30);
        Student student4 = new Student(40);
        Student student5 = new Student(50);
        Student student6 = new Student(60);
        Student student7 = new Student(70);
        Student student8 = new Student(80);
        Student student9 = new Student(90);
        Student student10 = new Student(100);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        students.add(student8);
        students.add(student9);
        students.add(student10);
    }

    @After
    public void clear() {
        students.clear();
    }

    @Test
    public void when10AThenChooseStudentsWithScore70To100() {
        Predicate<Student> condition10A = x -> (x.getScore() >= 70) && (x.getScore() <= 100);
        List<Student> actual = testSchool.collect(students, condition10A);
        List<Student> expected = List.of(
                new Student(70),
                new Student(80),
                new Student(90),
                new Student(100)
        );
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void when10BThenChooseStudentsWithScore70To100() {
        Predicate<Student> condition10B = x -> (x.getScore() >= 50) && (x.getScore() < 70);
        List<Student> actual = testSchool.collect(students, condition10B);
        List<Student> expected = List.of(
                new Student(50),
                new Student(60)
        );
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void when10CThenChooseStudentsWithScore0To50() {
        Predicate<Student> condition10C = x -> (x.getScore() >= 0) && (x.getScore() < 50);
        List<Student> actual = testSchool.collect(students, condition10C);
        List<Student> expected = List.of(
                new Student(10),
                new Student(20),
                new Student(30),
                new Student(40)
        );
        Assert.assertThat(actual, is(expected));
    }
}
