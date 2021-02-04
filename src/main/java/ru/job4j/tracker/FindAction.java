package ru.job4j.tracker;

public class FindAction implements UserAction{
    @Override
    public String name() {
        return "=== Find item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Enter id:"));
        Item item = tracker.findById(id);
        System.out.println(item != null ? item.toString() : "Заявка с таким id не найдена.");
        return true;
    }
}
