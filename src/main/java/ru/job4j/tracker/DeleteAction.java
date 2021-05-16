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
    public boolean execute(Input input, Store memTracker) {
        int id = Integer.valueOf(input.askStr("Enter id:"));
        try {
            out.println(memTracker.delete(id) ? "Successful" : "Error");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
}
