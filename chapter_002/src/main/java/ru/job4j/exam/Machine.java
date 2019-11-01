package ru.job4j.exam;

import java.util.Arrays;

public class Machine {
    private final int[] coins = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int changeAmount = money - price;
        int currentCoin = 0;
        int count = 0;
        while (changeAmount > 0) {
            if ((changeAmount - coins[currentCoin] >= 0)) {
                changeAmount -= coins[currentCoin];
                rsl[count++] = coins[currentCoin];
            } else {
                currentCoin++;
            }
        }
        return Arrays.copyOf(rsl, count);
    }
}
