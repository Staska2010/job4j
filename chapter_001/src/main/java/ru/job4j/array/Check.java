package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (boolean index : data) {
            result = result && index;
        }
        return result;
    }
}
