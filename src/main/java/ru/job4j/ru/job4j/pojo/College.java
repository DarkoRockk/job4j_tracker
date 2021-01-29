package ru.job4j.ru.job4j.pojo;

import java.time.LocalDate;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Shadrin Dmitry Andreevich");
        student.setGroup("1-А");
        student.setAdmission(LocalDate.of(2017, 6,12));
        System.out.println(student.getName() + " " + student.getGroup() + " " + student.getAdmission());
    }
}
