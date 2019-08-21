package ru.job4j.loop;

public class Factorial {
    public int calc(int n) {
        if (n == 0) {
            return 1;
        }
        return n * calc(n - 1);
    }
}
