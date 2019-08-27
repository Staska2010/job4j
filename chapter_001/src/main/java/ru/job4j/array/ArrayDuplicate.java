package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int endOfArray = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j <= endOfArray; j++) {
                if (array[j].equals(array[i])) {
                    // переносим совпадение в конец массива
                    String tmp = array[endOfArray];
                    array[endOfArray] = array[j];
                    array[j] = tmp;
                    endOfArray--;
                }
            }
        }
        return Arrays.copyOf(array, endOfArray + 1);
    }
}
