package ru.job4j.loop;

public class Mortgage {
    public int year(int amount, int monthly, double percent) {
        int year = 0;
        amount *= (100 + percent) / 100;
        while (amount > 0) {
            for (int i = 0; i < 12; i++) {
                if (amount < 0) {
                    break;
                }
                amount -= monthly;
            }
            year++;
        }
        return year;
    }
}
