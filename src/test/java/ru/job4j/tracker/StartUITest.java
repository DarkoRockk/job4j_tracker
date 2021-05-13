package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() throws IOException {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() throws IOException {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", Integer.toString(item.getId()), replacedName, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() throws IOException {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[]{"0", Integer.toString(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() throws IOException {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Exit program ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenShowAll() throws IOException {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "test", "1", "2"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ShowAllAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Create a new Item ===" + System.lineSeparator()
                        + "1. === All items ===" + System.lineSeparator()
                        + "2. === Exit program ===" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Create a new Item ===" + System.lineSeparator()
                        + "1. === All items ===" + System.lineSeparator()
                        + "2. === Exit program ===" + System.lineSeparator()
                        + tracker.findAll().get(0).toString() + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Create a new Item ===" + System.lineSeparator()
                        + "1. === All items ===" + System.lineSeparator()
                        + "2. === Exit program ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindById() throws IOException {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "test", "1", "1", "2"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new FindAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Create a new Item ===" + System.lineSeparator()
                        + "1. === Find item ===" + System.lineSeparator()
                        + "2. === Exit program ===" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Create a new Item ===" + System.lineSeparator()
                        + "1. === Find item ===" + System.lineSeparator()
                        + "2. === Exit program ===" + System.lineSeparator()
                        + tracker.findById(1).toString() + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Create a new Item ===" + System.lineSeparator()
                        + "1. === Find item ===" + System.lineSeparator()
                        + "2. === Exit program ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByName() throws IOException {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "test", "1", "test", "2"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Create a new Item ===" + System.lineSeparator()
                        + "1. === Find item by name ===" + System.lineSeparator()
                        + "2. === Exit program ===" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Create a new Item ===" + System.lineSeparator()
                        + "1. === Find item by name ===" + System.lineSeparator()
                        + "2. === Exit program ===" + System.lineSeparator()
                        + tracker.findByName("test").get(0).toString() + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. === Create a new Item ===" + System.lineSeparator()
                        + "1. === Find item by name ===" + System.lineSeparator()
                        + "2. === Exit program ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() throws IOException {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"7", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. === Exit program ===%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. === Exit program ===%n"
                )
        ));
    }
}