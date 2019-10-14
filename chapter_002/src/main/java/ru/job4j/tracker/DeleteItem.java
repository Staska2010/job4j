package ru.job4j.tracker;

public class DeleteItem extends BaseAction {
    public DeleteItem (int key, String name){
        super(key, name);
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
