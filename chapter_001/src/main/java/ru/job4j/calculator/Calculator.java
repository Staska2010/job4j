package ru.job4j.calculator;

/**
 * Calculator
 *
 * @author Stanislav Klokov
 */

public class Calculator {
    /**
     * Метод, вычисляющий сумму двух чисел
     *
     * @param first  - первое число
     * @param second - второе число
     */
    public static void add(double first, double second) {
        double result = first + second;
        System.out.println(first + " + " + second + " = " + result);
    }

    public static void div(double first, double second) {
        double result = first / second;
        System.out.println(first + " / " + second + " = " + result);
    }

    public static void multiply(double first, double second) {
        double result = first * second;
        System.out.println(first + " * " + second + " = " + result);
    }

    public static void subtrack(double first, double second) {
        double result = first + second;
        System.out.println(first + " - " + second + " = " + result);
    }

    /**
     * Метод main запуска вывода на консоль результатов вычислений.
     *
     * @param args - args
     */
    public static void main(String[] args) {
        add(1, 1);
        multiply(2, 2);
        subtrack(4, 2);
        div(10, 2);
    }
}
