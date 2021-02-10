package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        List<Account> list = users.get(findByPassport(passport));
        if (!list.contains(account)) {
            list.add(account);
        }
        users.put(findByPassport(passport), list);
    }

    public User findByPassport(String passport) {
        User user = null;
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                user = key;
            }
        }
        return user;
    }

    public Account findByRequisite(String passport, String requisite) {
        List<Account> list = users.get(findByPassport(passport));
        if (list != null) {
            for (Account acc : list) {
                if (acc.getRequisite().equals(requisite)) {
                    return acc;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        if (users.containsKey(findByPassport(srcPassport)) &&
                users.containsKey(findByPassport(destPassport))) {
            List<Account> srcList = users.get(findByPassport(srcPassport));
            List<Account> destList = users.get(findByPassport(destPassport));
            Account src = findByRequisite(srcPassport, srcRequisite);
            Account dest = findByRequisite(destPassport, destRequisite);
            int srcIndex = srcList.indexOf(src);
            int destIndex = destList.indexOf(dest);
            if (src.getBalance() >= amount) {
                src.setBalance(src.getBalance() - amount);
                dest.setBalance(dest.getBalance() + amount);
                srcList.set(srcIndex, src);
                destList.set(destIndex, dest);
                users.put(findByPassport(srcPassport), srcList);
                users.put(findByPassport(destPassport), destList);
                rsl = true;
            }
        }
        return rsl;
    }
}
