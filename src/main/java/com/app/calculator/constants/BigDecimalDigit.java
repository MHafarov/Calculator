package com.app.calculator.constants;

import java.math.BigDecimal;

public enum BigDecimalDigit {
    ZERO(0), ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5);
    private final BigDecimal number;

    BigDecimalDigit (int number) {
        this.number = new BigDecimal(number);
    }
    BigDecimalDigit (String number) {
        this.number = new BigDecimal(number);
    }
    public BigDecimal getNumber() {
        return number;
    }
}

