package ru.job4j.bank;

import java.math.BigDecimal;
import java.util.*;

public class Bank {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        users.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        User user = findUserByPassport(passport);
        if (user != null) {
            users.get(user).add(account);
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        User user = findUserByPassport(passport);
        if (user != null) {
            int position = users.get(user).indexOf(account);
            if (position >= 0) {
                users.get(user).remove(position);
            }
        }
    }

    public List<Account> getUserAccounts(String passport) {
        User user = findUserByPassport(passport);
        return (user != null) ?
                users.get(user)
                : new ArrayList<Account>();
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean result = false;
        Account srcAccount = findAccountByRequisite(srcRequisite, getUserAccounts(srcPassport));
        Account destAccount = findAccountByRequisite(destRequisite, getUserAccounts(destPassport));
        if ((srcAccount != null) && (destAccount != null)) {
            if (srcAccount.withdraw(BigDecimal.valueOf(amount))) {
                destAccount.deposit(BigDecimal.valueOf(amount));
                result = true;
            }
        }
        return result;
    }

    private User findUserByPassport(String passport) {
        User result = users.keySet().stream()
                .filter(s -> s.getPassport().equals(passport))
                .findAny().orElse(null);
        return result;
    }

    private Account findAccountByRequisite(String requisite, List<Account> accounts) {
        Account result = accounts.stream()
                .filter(s -> s.getRequisites().equals(requisite))
                .findFirst().orElse(null);
        return result;
    }
}
