package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void sort() {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[]{"0", "Item1", "0", "Item2", "0", "Item3", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList();
        actions.add(new CreateAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, tracker, actions);
        List<Item> list = tracker.findAll();
        list.get(0).setId(10);
        Collections.sort(list, new ItemSortComparator());
        assertThat(list.get(0).getId(), is(2));
        Collections.sort(list, new ItemReverseComparator());
        System.out.println(list);
    }
    @Test
    public void reverse() {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[]{"0", "Item1", "0", "Item2", "0", "Item3", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList();
        actions.add(new CreateAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, tracker, actions);
        List<Item> list = tracker.findAll();
        list.get(0).setId(10);
        Collections.sort(list, new ItemReverseComparator());
        assertThat(list.get(2).getId(), is(2));
    }

}