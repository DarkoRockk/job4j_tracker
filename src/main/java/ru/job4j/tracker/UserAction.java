package ru.job4j.tracker;

import java.io.IOException;
import java.sql.SQLException;

public interface UserAction {
    String name();

    boolean execute(Input input, Store tracker) throws IOException, SQLException;

}
