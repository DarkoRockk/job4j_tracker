package ru.job4j.tracker;

import java.sql.SQLException;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        int id = Integer.valueOf(input.askStr("Enter id:"));
        String name = input.askStr("Enter name:");
        Item item = new Item(name);
        out.println(memTracker.replace(id, item) ? "Successful" : "Error");
        return true;
    }
}
