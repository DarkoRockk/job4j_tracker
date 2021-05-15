package ru.job4j.tracker;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class MemTrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws IOException {
        MemTracker memTracker = ru.job4j.tracker.MemTracker.getInstance();
        Item item = new Item("test1");
        memTracker.add(item);
        Item result = memTracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() throws IOException {
        MemTracker memTracker = ru.job4j.tracker.MemTracker.getInstance();
        Item bug = new Item("Bug");
        memTracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        memTracker.replace(id, bugWithDesc);
        assertThat(memTracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() throws IOException {
        MemTracker memTracker = ru.job4j.tracker.MemTracker.getInstance();
        Item bug = new Item("Bug");
        memTracker.add(bug);
        int id = bug.getId();
        memTracker.delete(id);
        assertThat(memTracker.findById(id), is(nullValue()));
    }
}