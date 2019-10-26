package ru.job4j.tracker;

import java.util.ArrayList;

public class FindItemsByName extends BaseAction {
    public FindItemsByName(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Введите имя заявки :");
        ArrayList<Item> items = tracker.findByName(name);
        if (items.size() == 0) {
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
