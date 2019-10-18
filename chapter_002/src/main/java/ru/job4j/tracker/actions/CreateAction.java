package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.UserAction;

public class CreateAction implements UserAction {
    @Override
    public int key() {
        return 0;
    }

    @Override
    public String name() {
        return "Добавление новой заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Введите имя заявки :");
        String desc = input.askStr("Введите описание заявки :");
        Item item = new Item(name, desc);
        if (tracker.add(item) != null) {
            System.out.println(" Новая заявка с getId: " + item.getId());
        } else {
            System.out.println("База переполнена!");
        }
        return true;
    }
}
