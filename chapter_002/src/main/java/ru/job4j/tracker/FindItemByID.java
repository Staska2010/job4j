package ru.job4j.tracker;

public class FindItemByID extends BaseAction {
    public FindItemByID(int key, String name) {
        super(key, name);
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
