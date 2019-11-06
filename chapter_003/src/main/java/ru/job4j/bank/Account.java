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
}
