package com.hsbc.kata.elephantcarpaccio;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Arrays;

public class Price {
    public BigDecimal getDiscountValue(BigDecimal p) {
        if (p.compareTo(DiscoutRate.FIFTYTHOUSAND.getOrderValue()) >= 0) {
            return DiscoutRate.FIFTYTHOUSAND.getDiscountPrice(p);
        } else if (p.compareTo(DiscoutRate.TENTHOUSAND.getOrderValue()) >= 0) {
            return DiscoutRate.TENTHOUSAND.getDiscountPrice(p);
        } else if (p.compareTo(DiscoutRate.SERVENTHOUSAND.getOrderValue()) >= 0) {
            return DiscoutRate.SERVENTHOUSAND.getDiscountPrice(p);
        } else if (p.compareTo(DiscoutRate.FIVETHOUSAND.getOrderValue()) >= 0) {
            return DiscoutRate.FIVETHOUSAND.getDiscountPrice(p);
        } else if (p.compareTo(DiscoutRate.ONETHOUSAND.getOrderValue()) >= 0) {
            return DiscoutRate.ONETHOUSAND.getDiscountPrice(p);
        } else if (p.compareTo(BigDecimal.valueOf(0)) <= 0) {
            return BigDecimal.ZERO;
        } else {
            return p;
        }
    }

    public BigDecimal getTotalPrice(int totalItems, BigDecimal pricePerItem, String statusCode) {
        BigDecimal initPrice = getInitPrice(totalItems, pricePerItem);
        BigDecimal discountValue = getDiscountValue(initPrice);
        return getStatePrice(discountValue, statusCode);
    }

    public BigDecimal getStatePrice(BigDecimal discountPrice, String stateCode) {
        StateRate stateRate = Arrays.stream(StateRate.values()).filter(x -> stateCode.equalsIgnoreCase(x.name())).findFirst().orElse(StateRate.NONE);
        return discountPrice.subtract(discountPrice.multiply(BigDecimal.valueOf(stateRate.getStateRate())));

    }

    public BigDecimal getInitPrice(int itemCount, BigDecimal itemPrice) {
        return itemPrice.multiply(BigDecimal.valueOf(itemCount));
    }

    enum StateRate {
        UT(0.0685),
        NV(0.0800),
        TX(0.0625),
        AL(0.0400),
        CA(0.0825),
        NONE(0);

        @Getter
        private double stateRate;

        StateRate(double stateRate) {
            this.stateRate = stateRate;
        }
    }

    enum DiscoutRate {
        ONETHOUSAND(BigDecimal.valueOf(1000), 0.03),
        FIVETHOUSAND(BigDecimal.valueOf(5000), 0.05),
        SERVENTHOUSAND(BigDecimal.valueOf(7000), 0.05),
        TENTHOUSAND(BigDecimal.valueOf(10000), 0.05),
        FIFTYTHOUSAND(BigDecimal.valueOf(50000), 0.05);
        @Getter
        private BigDecimal orderValue;
        @Getter
        private double discountRate;

        DiscoutRate(BigDecimal orderValue, double discountRate) {
            this.orderValue = orderValue;
            this.discountRate = discountRate;
        }

        public BigDecimal getDiscountPrice(BigDecimal initPrice) {
            return initPrice.subtract(initPrice.multiply(BigDecimal.valueOf(discountRate)));
        }
    }

}
