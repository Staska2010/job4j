package ru.job4j.tracker;

public class StubInput implements Input {
    private final String[] answers;
    private int position;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String askStr(String input) {
        return answers[position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.valueOf(askStr(question));
    }

    @Override
    public int askInt(String question, int max) {
        return askInt(question);
    }
}
