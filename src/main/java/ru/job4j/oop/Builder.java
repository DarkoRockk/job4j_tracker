package ru.job4j.oop;

import java.util.Date;

public class Builder extends Engineer{

    public Builder(String name, String surname, String education, Date birthday) {
        super(name, surname, education, birthday);
    }
    public void makeProject() {}
}
