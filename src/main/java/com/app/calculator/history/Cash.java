package com.app.calculator.history;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Cash {
    private HashMap<String, BigDecimal> cash = new HashMap<>();

    public Cash() {
        cash.put(null, null);
    }

    public BigDecimal getCashDigit() {
        Collection<BigDecimal> values_Collection = cash.values();
        Set<BigDecimal> values_Set = new HashSet<>(values_Collection);

        BigDecimal cash_Value = null;

        if (values_Set.size() <= 1) {
            for (BigDecimal element : values_Set) {
                cash_Value = element;
            }
        }
        return cash_Value;
    }

    public void setCashDigit(BigDecimal cash) {
        this.cash[0] = cash;
    }
}
