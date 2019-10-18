package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.UserAction;

public class ShowAllItemsAction implements UserAction {

    @Override
    public int key() {
        return 1;
    }

    @Override
    public String name() {
        return  "Вывод заявок";
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
