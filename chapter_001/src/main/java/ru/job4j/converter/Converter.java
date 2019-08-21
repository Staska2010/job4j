package ru.job4j.converter;

public class Converter {
    public static int rubleToEuro(int value) {
        return value / 70;
    }

    public static int rubleToDollar(int value) {
        return value / 65;
    }

    public static int DollarToRuble(int value) {
        return value * 65;
    }

    public static int EuroToRuble(int value) {
        return value * 70;
    }

    public static void main(String[] args) {
        int euro = rubleToEuro(140);
        System.out.println("140 rubles are " + euro + " euro.");
        int dollar = rubleToDollar(140);
        System.out.println("140 rubles are " + dollar + " dollar.");
        int ruble = EuroToRuble(10);
        System.out.println("10 euros are " + ruble + " rubles.");
        ruble = DollarToRuble(10);
        System.out.println("10 dollars are " + ruble + " rubles.");

        int in = 140;
        int expected = 2;
        int out = rubleToEuro(in);
        boolean passed = expected == out;
        System.out.println("140 rubles are 2. Test result : " + passed);
    }
}
