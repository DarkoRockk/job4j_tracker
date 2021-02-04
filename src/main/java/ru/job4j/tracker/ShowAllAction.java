package ru.job4j.tracker;

public class ShowAllAction implements UserAction{

    @Override
    public String name() {
        return "=== All items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        for (Item item : items) {
            System.out.println(item.toString());
        }
        return true;
    }
}