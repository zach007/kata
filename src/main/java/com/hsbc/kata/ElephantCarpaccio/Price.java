package com.hsbc.kata.ElephantCarpaccio;

import java.math.BigDecimal;

public class Price {
    public BigDecimal getDiscountValue(BigDecimal p) {
        if (getDiscoutRate(p)) {
            return BigDecimal.valueOf(0);
        } else if (p.compareTo(BigDecimal.valueOf(1000)) >= 0) {
            return p.subtract(p.multiply(BigDecimal.valueOf(0.03)));
        } else if (p.compareTo(BigDecimal.valueOf(5000)) >= 0) {
            return p.subtract(p.multiply(BigDecimal.valueOf(0.05)));
        } else if (p.compareTo(BigDecimal.valueOf(7000)) >= 0) {
            return p.subtract(p.multiply(BigDecimal.valueOf(0.07)));
        } else {
            return p;
        }

    }

    private boolean getDiscoutRate(BigDecimal p) {
        return p.compareTo(BigDecimal.valueOf(0)) == -1;
    }

    public int getTotalPrice(int totalItems, BigDecimal pricePerItem, String statusCode) {
        return -1;
    }
}
