package ru.job4j.bank;

import java.util.*;
import java.util.stream.Stream;

/**
 * Класс работу банковского сервиса
 *
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
     *
     * @param user пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет новый счет пользователю в коллекции,
     * при условии, что этот пользователь существует. Поиск пользователя
     * ведется по его номеру паспорта.
     *
     * @param passport номер паспорта пользователя
     * @param account  счет для добавления
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> list = users.get(user.get());
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод осуществляет поиск пользователя в коллекции
     * по его номеру паспорта.
     *
     * @param passport номер паспорта пользователя
     * @return искомый пользователь
     */
    public Optional<User> findByPassport(String passport) {

        return users.keySet().stream()
                .filter(key -> key.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод осуществляет поиск нужного счета по
     * реквизитам и номеру паспорта пользователя.
     *
     * @param passport  номер паспорта пользователя
     * @param requisite реквизиты счета
     * @return искомый счет
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return users.get(user.get()).stream()
                .filter(acc -> acc.getRequisite().equals(requisite))
                .findFirst();

    }

    /**
     * Метод осуществляет перевод денежных средств с одного счета
     * на другой, при условии, что на первом достаточное количетсво
     * денежных средств. Поиск счетов ведется по реквизитам и номеру
     * паспорта пользователя.
     *
     * @param srcPassport   номер паспорта пользователя, переводящего деньги
     * @param srcRequisite  реквизиты счета с которого переводят деньги
     * @param destPassport  номер паспорта пользователя, принимающего деньги
     * @param destRequisite реквизиты счета принимающей стороны
     * @param amount        количество переводимых денежных средств
     * @return отет об успешности проведенной опреации true или false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> src = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> dest = findByRequisite(destPassport, destRequisite);
        if (src.isPresent() && dest.isPresent() && src.get().getBalance() >= amount) {
            src.get().setBalance(src.get().getBalance() - amount);
            dest.get().setBalance(dest.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
