package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            }
            else if (select == 1) {
                System.out.println("=== All items ====");
                Item[] items = tracker.findAll();
                for (Item item : items) {
                    System.out.println(item.toString());
                }
            }
            else if (select == 2) {
                System.out.println("=== Edit item ====");
                int id = Integer.valueOf(input.askStr("Enter id:"));
                String name = input.askStr("Enter name:");
                Item item = new Item(name);
                System.out.println(tracker.replace(id, item) ? "Successful" : "Error");
            }
            else if (select == 3) {
                System.out.println("=== Delete item ====");
                int id = Integer.valueOf(input.askStr("Enter id:"));
                System.out.println(tracker.delete(id) ? "Successful" : "Error");
            }
            else if (select == 4) {
                System.out.println("=== Find item ====");
                int id = Integer.valueOf(input.askStr("Enter id:"));
                Item item = tracker.findById(id);
                System.out.println(item != null ? item.toString() : "Заявка с таким id не найдена." );
            }
            else if (select == 5) {
                System.out.println("=== Find item by name ====");
                String name = input.askStr("Enter name:");
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item.toString());
                    }
                }
                else {
                    System.out.println("Заявки с таким именем не надены.");
                }
            }
            else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("===== Menu =====");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
