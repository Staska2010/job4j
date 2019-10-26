package ru.job4j.tracker;

import ru.job4j.tracker.actions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class StartUI {

    public void init(Input input, Tracker tracker, ArrayList<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Введите пункт меню : ", 7);
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(ArrayList<UserAction> actions) {
        System.out.println("Меню.");
        for (UserAction i : actions) {
            System.out.println(i.name());
        }
    }

    /**
     * Запуск программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<UserAction> actions = new ArrayList<>(Arrays.asList(new CreateAction(),
                new ShowAllItemsAction(), new DeleteItemAction(), new EditItemAction(),
                new FindByIdAction(), new FinditemsByNameAction(), new ExitAction()));
        Tracker tracker = new Tracker();
        Input input = new ValidateInput(new ConsoleInput());
        new StartUI().init(input, tracker, actions);
    }
}
