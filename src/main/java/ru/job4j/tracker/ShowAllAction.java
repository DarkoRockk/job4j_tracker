package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.List;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== All items ===";
    }

    @Override
    public boolean execute(Input input, Store memTracker) throws SQLException {
        List<Item> items = memTracker.findAll();
        for (Item item : items) {
            out.println(item.toString());
        }
        return true;
    }
}
