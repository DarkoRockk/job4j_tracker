package ru.job4j.tracker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class MemTracker {
    private static MemTracker instance = null;
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public MemTracker() {
    }

    public static MemTracker getInstance() {
        if (instance == null) {
            instance = new MemTracker();
        }
        return instance;
    }

    public Item add(Item item) throws IOException {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int i = indexOf(id);
        if (i != -1) {
            item.setId(id);
            items.set(i, item);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        int i = indexOf(id);
        if (i != -1) {
            items.remove(i);
            return true;
        }
        return false;
    }
}