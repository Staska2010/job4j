package ru.job4j.tracker;

public class StartUI {
    private static final int ADD = 0;
    private static final int SHOW = 1;
    private static final int EDIT = 2;
    private static final int DEL = 3;
    private static final int FINDID = 4;
    private static final int FINDNAME = 5;
    private static final int EXIT = 6;

    private final Input input;
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            int answer = input.askInt("Введите пункт меню : ", 7);
            switch (answer) {
                case ADD:
                    createItem();
                    break;
                case SHOW:
                    showAllItems();
                    break;
                case EDIT:
                    editItem();
                    break;
                case DEL:
                    deleteItem();
                    break;
                case FINDID:
                    findItemById();
                    break;
                case FINDNAME:
                    findItemsByName();
                    break;
                case EXIT:
                    exit = true;
                    break;
                default:
                    System.out.println("Повторите ввод.");
            }
        }
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Добавить новую заявку");
        System.out.println("1. Показать все заявки");
        System.out.println("2. Редактировать заявку");
        System.out.println("3. Удалить заявку");
        System.out.println("4. Найти заявку по ID");
        System.out.println("5. Найти заявки по названию");
        System.out.println("6. Выход");
    }

    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = input.askStr("Введите имя заявки :");
        String desc = input.askStr("Введите описание заявки :");
        Item item = new Item(name, desc);
        if (tracker.add(item) != null) {
            System.out.println("--------- Новая заявка с getId : " + item.getId() + "-----------");
        } else {
            System.out.println("--------- База переполнена! -----------");
        }

    }

    private void showAllItems() {
        System.out.println("------------------- Заявки ------------------------");
        for (Item iterator : tracker.findAll()) {
            System.out.println("ID: " + iterator.getId() + "; name: " + iterator.getName() + "; desc: "
                    + iterator.getDesc());
        }
        System.out.println("---------------------------------------------------");
    }

    private void editItem() {
        System.out.println("-------------- Редактирование заявки --------------");
        String id = input.askStr("Введите ID редактируемой заявки :");
        String name = input.askStr("Введите новое название заявки :");
        String desc = input.askStr("Введите новое описание :");
        Item item = new Item(name, desc);
        if (tracker.replace(id, item)) {
            System.out.println("---------- Заявка успешна изменена-------------");
        } else {
            System.out.println("------- Заявка с ID:" + item.getName() + " не найдена-------");
        }

    }

    private void deleteItem() {
        System.out.println("---------------- Удаление заявки ------------------");
        String id = input.askStr("Введите ID заявки :");
        if (tracker.delete(id)) {
            System.out.println("---------Заявка с ID: " + id + " удалена-------");
            showAllItems();
        } else {
            System.out.println("---------- Заявка c ID: " + id + " не найдена----");
        }
    }

    private void findItemById() {
        System.out.println("--------------- Найти заявку по ID ----------------");
        String id = input.askStr("Введите ID заявки :");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("------------ Заявка: ID" + item.getId() + ", name:  " + item.getName()
                    + "; desc: " + item.getDesc() + "---------");
        } else {
            System.out.println("---------- Заявка c ID: " + id + " не найдена----");
        }

    }

    private void findItemsByName() {
        System.out.println("------------ Найти заявки по названию --------------");
        String name = this.input.askStr("Введите имя заявки :");
        Item[] items = tracker.findByName(name);
        if (items.length == 0) {
            System.out.println("---------- Заявки с именем: " + name + " не найдены----");
        } else {
            System.out.println("------------------- Заявки ------------------------");
            for (Item iterator : items) {
                System.out.println("ID: " + iterator.getId() + "; name: " + iterator.getName() + "; desc: "
                        + iterator.getDesc());
            }
            System.out.println("---------------------------------------------------");
        }
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}
