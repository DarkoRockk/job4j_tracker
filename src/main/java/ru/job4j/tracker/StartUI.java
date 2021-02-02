package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Tracker track = new Tracker();
        track.add(new Item());
        System.out.println(track.findById(1));

        Item item = new Item();
        item.setName("Траляля");
        item.setId(400);
        System.out.println(item);
    }
}
