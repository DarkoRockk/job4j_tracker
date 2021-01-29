package ru.job4j.oop;

public class Item {
    private String name;
    private int id;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
