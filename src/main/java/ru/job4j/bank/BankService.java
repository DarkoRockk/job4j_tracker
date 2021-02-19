package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс работу банковского сервиса
 * @author DMITRIY SHADRIN
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей и их счетов
     * осущетвляется в коллекции типа HashMap
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимет нового ползователя и,
     * если такого не сущетсвует, добавляет его в  коллекцию
     * @param user пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет новый счет пользователю в коллекции,
     * при условии, что этот пользователь существует. Поиск пользователя
     * ведется по его номеру паспорта.
     * @param passport номер паспорта пользователя
     * @param account счет для добавления
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод осуществляет поиск пользователя в коллекции
     * по его номеру паспорта.
     * @param passport номер паспорта пользователя
     * @return искомый пользователь
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(key -> key.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод осуществляет поиск нужного счета по
     * реквизитам и номеру паспорта пользователя.
     * @param passport номер паспорта пользователя
     * @param requisite реквизиты счета
     * @return искомый счет
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user). stream()
                    .filter(acc -> acc.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод осуществляет перевод денежных средств с одного счета
     * на другой, при условии, что на первом достаточное количетсво
     * денежных средств. Поиск счетов ведется по реквизитам и номеру
     * паспорта пользователя.
     * @param srcPassport номер паспорта пользователя, переводящего деньги
     * @param srcRequisite реквизиты счета с которого переводят деньги
     * @param destPassport номер паспорта пользователя, принимающего деньги
     * @param destRequisite реквизиты счета принимающей стороны
     * @param amount количество переводимых денежных средств
     * @return отет об успешности проведенной опреации true или false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null && dest != null && src.getBalance() >= amount) {
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
