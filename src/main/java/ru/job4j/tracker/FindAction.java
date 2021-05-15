package ru.job4j.tracker;

import java.sql.SQLException;

public class FindAction implements UserAction {
    private final Output out;

    public FindAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item ===";
    }

    @Override
    public boolean execute(Input input, Store memTracker) throws SQLException {
        int id = Integer.valueOf(input.askStr("Enter id:"));
        Item item = memTracker.findById(id);
        out.println(item != null ? item.toString() : "Заявка с таким id не найдена.");
        return true;
    }
}
