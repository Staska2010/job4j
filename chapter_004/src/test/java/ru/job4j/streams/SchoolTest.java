package ru.job4j.streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;

public class SchoolTest {
    @Test
    public void when10AThenChooseStudentsWithScore70To100() {
        Predicate<Student> condition10A = x -> (x.getScore() >= 70) && (x.getScore() <= 100);
        School testSchool = new School();
        List<Student> actual = testSchool.collect(List.of(
                new Student(10),
                new Student(20),
                new Student(30),
                new Student(40),
                new Student(50),
                new Student(60),
                new Student(70),
                new Student(80),
                new Student(90),
                new Student(100)),
                condition10A);
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
        School testSchool = new School();
        List<Student> actual = testSchool.collect(List.of(
                new Student(10),
                new Student(20),
                new Student(30),
                new Student(40),
                new Student(50),
                new Student(60),
                new Student(70),
                new Student(80),
                new Student(90),
                new Student(100)),
                condition10B);
        List<Student> expected = List.of(
                new Student(50),
                new Student(60)
        );
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void when10CThenChooseStudentsWithScore0To50() {
        Predicate<Student> condition10C = x -> (x.getScore() >= 0) && (x.getScore() < 50);
        School testSchool = new School();
        List<Student> actual = testSchool.collect(List.of(
                new Student(10),
                new Student(20),
                new Student(30),
                new Student(40),
                new Student(50),
                new Student(60),
                new Student(70),
                new Student(80),
                new Student(90),
                new Student(100)),
                condition10C);
        List<Student> expected = List.of(
                new Student(10),
                new Student(20),
                new Student(30),
                new Student(40)
        );
        Assert.assertThat(actual, is(expected));
    }
}
