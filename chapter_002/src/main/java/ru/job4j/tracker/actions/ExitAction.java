package ru.job4j.tracker;

public class ExitAction implements UserAction {
    @Override
    public int key() {
        return 6;
    }

    @Override
    public String name() {
        return "Выход";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
