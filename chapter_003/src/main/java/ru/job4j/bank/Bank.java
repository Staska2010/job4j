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
        users.get(findUserByPassport(passport)).add(account);
    }

    public void deleteAccountFromUser(String passport, Account account) {
        users.get(findUserByPassport(passport)).remove(account);
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean result = false;
        Account srcAccount = findAccountByRequisite(srcRequisite, getUserAccounts(srcPassport));
        Account destAccount = findAccountByRequisite(destRequisite, getUserAccounts(destPassport));
        if ((srcAccount != null) && (destAccount != null)) {
            if (srcAccount.getValue().subtract(BigDecimal.valueOf(amount)).intValue() >= 0) {
                destAccount.setValue(destAccount.getValue().add(BigDecimal.valueOf(amount)));
                srcAccount.setValue(srcAccount.getValue().subtract(BigDecimal.valueOf(amount)));
                result = true;
            }
        }
        return result;
    }

    public List<Account> getUserAccounts(String passport) {
        return users.get(findUserByPassport(passport));
    }

    private User findUserByPassport(String passport) {
        User result = null;
        for (User iterator : users.keySet()) {
            if (iterator.getPassport().equals(passport)) {
                result = iterator;
                break;
            }
        }
        return result;
    }

    private Account findAccountByRequisite(String requisite, List<Account> accounts) {
        Account result = null;
        for (Account iterator : accounts) {
            if (iterator.getRequisites().equals(requisite)) {
                result = iterator;
                break;
            }
        }
        return result;
    }
}
