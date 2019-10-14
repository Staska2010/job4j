package ru.job4j.tracker;

public class StubAction implements UserAction {
    public boolean call = false;

    @Override
    public int key() {
        return 0;
    }

    @Override
    public String name() {
        return "StubAction";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        call = true;
        return false;
    }
}
