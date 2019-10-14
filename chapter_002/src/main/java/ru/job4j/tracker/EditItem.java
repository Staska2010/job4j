package ru.job4j.tracker;

public class EditItem extends BaseAction {
    public EditItem(int key, String name){
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Введите ID редактируемой заявки :");
        String name = input.askStr("Введите новое название заявки :");
        String desc = input.askStr("Введите новое описание :");
        Item item = new Item(name, desc);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка успешна изменена");
        } else {
            System.out.println("Заявка с ID:" + item.getName() + " не найдена");
        }
        return true;
    }
}
