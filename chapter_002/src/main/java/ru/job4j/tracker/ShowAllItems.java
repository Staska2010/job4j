package ru.job4j.tracker;

public class ShowAllItems extends BaseAction {
    public ShowAllItems(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        for (Item iterator : tracker.findAll()) {
            System.out.println("ID: " + iterator.getId() + "; name: " + iterator.getName() + "; desc: "
                    + iterator.getDesc());
        }
        return true;
    }
}
