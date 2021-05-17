package ru.job4j.tracker;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {

    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void sort() throws IOException, SQLException {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[]{"0", "Item1", "0", "Item2", "0", "Item3", "1"}
        );
        Store memTracker = new SqlTracker(ConnectionRollback.create(this.init()));
        List<UserAction> actions = new ArrayList();
        actions.add(new CreateAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, memTracker, actions);
        List<Item> list = memTracker.findAll();
        list.get(0).setId(10);
        Collections.sort(list, new ItemSortComparator());
        assertThat(list.get(0).getId(), is(10));
        Collections.sort(list, new ItemReverseComparator());
        System.out.println(list);
    }

    @Test
    public void reverse() throws IOException, SQLException {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[]{"0", "Item1", "0", "Item2", "0", "Item3", "1"}
        );
        Store memTracker = new SqlTracker(ConnectionRollback.create(this.init()));
        List<UserAction> actions = new ArrayList();
        actions.add(new CreateAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, memTracker, actions);
        List<Item> list = memTracker.findAll();
        list.get(0).setId(10);
        Collections.sort(list, new ItemReverseComparator());
        assertThat(list.get(2).getId(), is(10));
    }

}