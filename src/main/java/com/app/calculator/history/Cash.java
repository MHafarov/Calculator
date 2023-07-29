package com.app.calculator.history;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;

public class Cash {
    private HashMap<String, BigDecimal> cash_HashMap = new HashMap<>();

    public Cash() {
        cash_HashMap.put(null, null);
    }


    public String getCashCommandText() {

        Collection<String> keys_Collection = cash_HashMap.keySet();
        String[] keys_Array = keys_Collection.toArray(new String[0]);

        String cash_Keys = keys_Array[0];

        return cash_Keys;
    }

    public BigDecimal getCashDigit() {

        Collection<BigDecimal> values_Collection = cash_HashMap.values();
        BigDecimal[] values_Array = values_Collection.toArray(new BigDecimal[0]);

        BigDecimal cash_Value = values_Array[0];

        return cash_Value;
    }

    public void setCash(String commandText, BigDecimal digit) {
        cash_HashMap.clear();
        cash_HashMap.put(commandText, digit);
    }

    public void clearCash() {
        cash_HashMap.clear();
        cash_HashMap.put(null, null);
    }
}
