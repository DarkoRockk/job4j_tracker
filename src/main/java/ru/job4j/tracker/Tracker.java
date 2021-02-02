package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] withoutNull = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                withoutNull[size] = items[i];
                size++;
            }
        }
        return Arrays.copyOf(withoutNull, size);
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equals(key)) {
                result[size] = items[i];
                size++;
            }
        }
        return Arrays.copyOf(result, size);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
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
            items[i] = item;
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        int i = indexOf(id);
        if (i != -1) {
            items[i] = null;
            System.arraycopy(items, i + 1, items, i, size - i);
            items[size - 1] = null;
            size--;
            return true;
        }
        return false;
    }
}