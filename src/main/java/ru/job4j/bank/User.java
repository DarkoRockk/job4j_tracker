package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя банковским сервисом
 *
 * @author DMITRIY SHADRIN
 * @version 1.0
 */
public class User {
    /**
     * Поле содержит номер пасспорта пользователя
     */
    private String passport;
    /**
     * Поле содержит имя пользователя
     */
    private String username;

    /**
     * Констркутор класса принимает 2 параметра
     *
     * @param passport номер паспорта пользователя
     * @param username имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * @return номер паспорта пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Сеттер устанавливает
     *
     * @param passport номер паспорта пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * @return имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Сеттер устанавливает
     *
     * @param username имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод сравнения
     *
     * @param o любой объект
     * @return результат сравнения true или false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Генерация хэшкода
     *
     * @return хэшкод
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
