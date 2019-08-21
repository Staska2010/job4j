package ru.job4j.calculator;

public class Calculator {
    public static void add(double first, double second) {
        double result =  first + second;
        System.out.println(first +  " + " + second + " = " + result);
    }

    public static void div(double first, double second) {
        double result =  first / second;
        System.out.println(first +  " / " + second + " = " + result);
    }

    public static void multiply(double first, double second) {
        double result =  first * second;
        System.out.println(first +  " * " + second + " = " + result);
    }

    public static void subtrack(double first, double second) {
        double result =  first + second;
        System.out.println(first +  " - " + second + " = " + result);
    }

    public static void main(String[] args) {
        add(1, 1);
        multiply(2, 2);
        subtrack(4, 2);
        div(10, 2);
    }
}
