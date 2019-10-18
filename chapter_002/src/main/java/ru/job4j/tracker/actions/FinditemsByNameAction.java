package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.UserAction;

public class FinditemsByNameAction implements UserAction {
    @Override
    public int key() {
        return 5;
    }

    @Override
    public String name() {
        return "Найти заявки по названию";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Введите имя заявки :");
        Item[] items = tracker.findByName(name);
        if (items.length == 0) {
            System.out.println("Заявки с именем: " + name + " не найдены");
        } else {
            System.out.println("Заявки:");
            for (Item iterator : items) {
                System.out.println("ID: " + iterator.getId() + "; name: " + iterator.getName() + "; desc: "
                        + iterator.getDesc());
            }
        }
        return true;
    }
}
