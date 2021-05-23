package ru.job4j.tracker;

import java.io.IOException;
import java.sql.SQLException;

public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Create a new Item ===";
    }

    @Override
    public boolean execute(Input input, Store memTracker) throws IOException {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        memTracker.add(item);
        return true;
    }
}
