package ru.job4j.streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * School
 * processing student's data
 *
 * @author Stanislav Klokov (klokovstas2013@gmail.com)
 */
public class School {

    /**
     * @param students list of Students for processing
     * @param predict  condition of processing
     * @return processed list of students
     */
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }
}
