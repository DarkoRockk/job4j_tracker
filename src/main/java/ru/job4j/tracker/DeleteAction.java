package ru.job4j.tracker;

public class DeleteAction implements UserAction{
    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Enter id:"));
        System.out.println(tracker.delete(id) ? "Successful" : "Error");
        return true;
    }
}