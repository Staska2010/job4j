package ru.job4j.bank;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BankTest {
    @Test
    public void whenAddUserWithAccountThenThisAccountIsInBank() {
        Bank bank = new Bank();
        User ivan = new User("Ivan", "218756");
        bank.addUser(ivan);
        Account ivanAccount = new Account();
        ivanAccount.setValue(BigDecimal.valueOf(100));
        ivanAccount.setRequisites("R1");
        bank.addAccountToUser("218756", ivanAccount);
        Account expected = bank.getUserAccounts("218756").get(0);
        assertThat(expected, is(ivanAccount));
    }

    @Test
    public void whenRemoveUserThenThereIsNotAccount() {
        Bank bank = new Bank();
        User ivan = new User("Ivan", "218756");
        bank.addUser(ivan);
        Account ivanAccount = new Account();
        ivanAccount.setValue(BigDecimal.valueOf(100));
        ivanAccount.setRequisites("R1");
        bank.addAccountToUser("218756", ivanAccount);
        bank.deleteUser(ivan);
        List<Account> expected = bank.getUserAccounts("218756");
        assertThat(expected, is(nullValue()));
    }

    @Test
    public void whenRemoveAccountAtUserThenThereIsNotSuchAccount() {
        Bank bank = new Bank();
        User ivan = new User("Ivan", "218756");
        bank.addUser(ivan);
        Account ivanAccount1 = new Account();
        ivanAccount1.setValue(BigDecimal.valueOf(100));
        ivanAccount1.setRequisites("R1");
        bank.addAccountToUser("218756", ivanAccount1);
        Account ivanAccount2 = new Account();
        ivanAccount2.setValue(BigDecimal.valueOf(100));
        ivanAccount2.setRequisites("R2");
        bank.addAccountToUser("218756", ivanAccount2);
        bank.deleteAccountFromUser("218756", ivanAccount2);
        boolean expected = bank.getUserAccounts("218756").contains(ivanAccount2);
        assertThat(expected, is(false));
    }

    @Test
    public void whenTransfer100ThenTrue() {
        Bank bank = new Bank();
        User ivan = new User("Ivan", "218756");
        User pavel = new User("Pavel", "425315");
        bank.addUser(ivan);
        bank.addUser(pavel);
        Account ivanAccount = new Account();
        ivanAccount.setValue(BigDecimal.valueOf(100));
        ivanAccount.setRequisites("R1");
        Account pavelAccount = new Account();
        pavelAccount.setValue(BigDecimal.valueOf(100));
        pavelAccount.setRequisites("R2");
        bank.addAccountToUser("218756", ivanAccount);
        bank.addAccountToUser("425315", pavelAccount);
        boolean expected = bank.transferMoney("218756", "R1", "425315", "R2", 100);
        assertThat(expected, is(true));
    }

    @Test
    public void whenTransfer200ThenFalse() {
        Bank bank = new Bank();
        User ivan = new User("Ivan", "218756");
        User pavel = new User("Pavel", "425315");
        bank.addUser(ivan);
        bank.addUser(pavel);
        Account ivanAccount = new Account();
        ivanAccount.setValue(BigDecimal.valueOf(100));
        ivanAccount.setRequisites("R1");
        Account pavelAccount = new Account();
        pavelAccount.setValue(BigDecimal.valueOf(100));
        pavelAccount.setRequisites("R2");
        bank.addAccountToUser("218756", ivanAccount);
        bank.addAccountToUser("425315", pavelAccount);
        boolean expected = bank.transferMoney("218756", "R1", "425315", "R2", 200);
        assertThat(expected, is(false));
    }
}
