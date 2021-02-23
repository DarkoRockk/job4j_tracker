package ru.job4j.oop;

public class Transport {
    public static void main(String[] args) {
        Vehicle plane = new Airplane();
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle[] transport = {plane, bus, train};
        for (Vehicle tr : transport) {
            tr.move();
        }
    }
}
