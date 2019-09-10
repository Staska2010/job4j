package ru.job4j.tracker;

public class StubInput implements Input {
    private final String[] answers;
    private int position;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    public String ask(String input) {
        return answers[position++];
    }
}
