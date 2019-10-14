package ru.job4j.tracker;

abstract class BaseAction implements UserAction{
    private final int key;
    private final String name;

    protected BaseAction(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String name() {
        return String.format("%s : %s", this.key, this.name());
    }
}
