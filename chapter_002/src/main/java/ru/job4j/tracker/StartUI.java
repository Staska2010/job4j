package ru.job4j.tracker;

import ru.job4j.tracker.actions.*;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Введите пункт меню : ", 7);
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Меню.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(actions[index].name());
        }
    }

    /**
     * Запуск программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        UserAction[] actions = new UserAction[]{new CreateAction(), new ShowAllItemsAction(), new DeleteItemAction(),
                new EditItemAction(), new FindByIdAction(), new FinditemsByNameAction(),
                new ExitAction()};
        Tracker tracker = new Tracker();
        Input input = new ValidateInput(new ConsoleInput());
        new StartUI().init(input, tracker, actions);
    }
}
