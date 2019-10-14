package ru.job4j.tracker;

public class StartUI {
    private static final int ADD = 0;
    private static final int SHOW = 1;
    private static final int EDIT = 2;
    private static final int DEL = 3;
    private static final int FINDID = 4;
    private static final int FINDNAME = 5;
    private static final int EXIT = 6;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */

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
     * Запускт программы.
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
