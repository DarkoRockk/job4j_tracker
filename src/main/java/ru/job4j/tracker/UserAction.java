package ru.job4j.tracker;

import java.io.IOException;

public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker) throws IOException;

}
