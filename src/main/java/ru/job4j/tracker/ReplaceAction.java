package ru.job4j.tracker;

public class ReplaceAction implements UserAction{
    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Enter id:"));
        String name = input.askStr("Enter name:");
        Item item = new Item(name);
        System.out.println(tracker.replace(id, item) ? "Successful" : "Error");
        return true;
    }
}