package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета
 * @author DMITRIY SHADRIN
 * @version 1.0
 */
public class Account {
    /**
     * Поле содержит реквизиты счета
     */
    private String requisite;
    /**
     * Поле содердит денежный баланс счета
     */
    private double balance;

    /**
     * Конструктор класса принимает два параметра
     * @param requisite реквизиты счета
     * @param balance баланс счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     *
     * @return реквизиты счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Сеттер устанавливает
     * @param requisite реквизиты счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     *
     * @return баланс денежного счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Сеттер устанавливает
     * @param balance баланс денежного счета
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    /**
     * Метод сравнения
     * @param o любой объект
     * @return результат сравнения true или false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }
    /**
     * Генерация хэшкода
     * @return хэшкод
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);

    }
}
