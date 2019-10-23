package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.UserAction;

public class DeleteItemAction implements UserAction {
    @Override
    public int key() {
        return 3;
    }

    @Override
    public String name() {
        return "Удаление заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Введите ID заявки :");
        if (tracker.delete(id)) {
            System.out.println("Заявка с ID: " + id + " удалена");
            new ShowAllItemsAction().execute(input, tracker);
        } else {
            System.out.println("Заявка c ID: " + id + " не найдена");
        }
        return true;
    }
}