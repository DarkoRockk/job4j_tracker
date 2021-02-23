package ru.job4j.oop;

import java.util.Date;

public class Engineer extends Profession {

    public Engineer(String name, String surname, String education, Date birthday) {
        super(name, surname, education, birthday);
    }

    public Drawing draw() {
        return new Drawing();
    }
}
