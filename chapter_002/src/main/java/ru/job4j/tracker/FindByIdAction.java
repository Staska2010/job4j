package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public int key() {
        return 4;
    }

    @Override
    public String name() {
        return "Найти заявку по ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Введите ID заявки :");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Заявка: ID" + item.getId() + ", name:  " + item.getName()
                    + "; desc: " + item.getDesc());
        } else {
            System.out.println("Заявка c ID: " + id + " не найдена");
        }
        return true;
    }
}
