package ru.job4j.tracker;

public class CreateItem extends BaseAction {

    public CreateItem(int key, String name) {
        super(key, name);
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
