package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by name ===";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        String name = input.askStr("Enter name:");
        List<Item> items = null;
        try {
            items = memTracker.findByName(name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item.toString());
            }
        } else {
            out.println("Заявки с таким именем не надены.");
        }
        return true;
    }
}
