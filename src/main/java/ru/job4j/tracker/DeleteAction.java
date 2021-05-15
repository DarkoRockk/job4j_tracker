package ru.job4j.tracker;

import java.sql.SQLException;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Store memTracker) throws SQLException {
        int id = Integer.valueOf(input.askStr("Enter id:"));
        out.println(memTracker.delete(id) ? "Successful" : "Error");
        return true;
    }
}
