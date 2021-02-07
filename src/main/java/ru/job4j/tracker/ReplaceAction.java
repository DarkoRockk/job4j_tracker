package ru.job4j.tracker;

public class ReplaceAction implements UserAction{
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Enter id:"));
        String name = input.askStr("Enter name:");
        Item item = new Item(name);
        out.println(tracker.replace(id, item) ? "Successful" : "Error");
        return true;
    }
}
