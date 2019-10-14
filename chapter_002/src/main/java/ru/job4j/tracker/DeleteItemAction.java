package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {
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
