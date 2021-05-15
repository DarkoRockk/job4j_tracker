package ru.job4j.tracker;

import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void sort() throws IOException, SQLException {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[]{"0", "Item1", "0", "Item2", "0", "Item3", "1"}
        );
        Store memTracker = new SqlTracker();
        List<UserAction> actions = new ArrayList();
        actions.add(new CreateAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, memTracker, actions);
        List<Item> list = memTracker.findAll();
        list.get(0).setId(10);
        Collections.sort(list, new ItemSortComparator());
        assertThat(list.get(0).getId(), is(2));
        Collections.sort(list, new ItemReverseComparator());
        System.out.println(list);
    }

    @Test
    public void reverse() throws IOException, SQLException {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[]{"0", "Item1", "0", "Item2", "0", "Item3", "1"}
        );
        Store memTracker = new SqlTracker();
        List<UserAction> actions = new ArrayList();
        actions.add(new CreateAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, memTracker, actions);
        List<Item> list = memTracker.findAll();
        list.get(0).setId(10);
        Collections.sort(list, new ItemReverseComparator());
        assertThat(list.get(2).getId(), is(2));
    }

}