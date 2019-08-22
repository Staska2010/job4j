package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {
        int count = 0;
        boolean notPrime;
        for (int i = 2; i <= finish; i++) {
            notPrime = false;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    notPrime = true;
                    break;
                }
            }
            if (!notPrime) count++;
        }
        return count;
    }
}
