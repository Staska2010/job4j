package ru.job4j.condition;

public class Max {
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    public int max(int first, int second, int third) {
        int tmp = max(second, third);
        return first > tmp ? first : tmp;
    }

    public int max(int first, int second, int third, int forth) {
        int tmp = max(second, third, forth);
        return first > tmp ? first : tmp;
    }
}
