package ru.job4j.bank;

import java.math.BigDecimal;

public class Account {
    private String requisites;
    private BigDecimal value;

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void deposit(BigDecimal amount) {
        BigDecimal currentAmount = getValue();
        setValue(currentAmount.add(amount));
    }

    public boolean withdraw(BigDecimal amount) throws InsufficientFundsException {
        BigDecimal currentAmount = getValue();
        boolean result = false;
        if (currentAmount.compareTo(amount) < 0) {
            throw new InsufficientFundsException("Not enough funds");
        } else {
            setValue(currentAmount.subtract(amount));
            result = true;
        }
        return result;
    }
}
