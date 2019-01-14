package com.hsbc.kata.ElephantCarpaccio;

import lombok.Getter;

import java.math.BigDecimal;

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
        if (stateCode.equals(StateRate.UT.getState())) {
            return StateRate.UT.getStatePrice(discountPrice);
        } else if (stateCode.equals(StateRate.NV.getState())) {
            return StateRate.NV.getStatePrice(discountPrice);
        } else if (stateCode.equals(StateRate.TX.getState())) {
            return StateRate.TX.getStatePrice(discountPrice);
        } else if (stateCode.equals(StateRate.AL.getState())) {
            return StateRate.AL.getStatePrice(discountPrice);
        } else if (stateCode.equals(StateRate.CA.getState())) {
            return StateRate.CA.getStatePrice(discountPrice);
        } else {
            return discountPrice;
        }
    }

    public BigDecimal getInitPrice(int itemCount, BigDecimal itemPrice) {
        return itemPrice.multiply(BigDecimal.valueOf(itemCount));
    }

    enum StateRate {
        UT("UT", 0.0685),
        NV("NV", 0.0800),
        TX("TX", 0.0625),
        AL("AL", 0.0400),
        CA("CA", 0.0825);
        @Getter
        private String state;
        @Getter
        private double stateRate;

        StateRate(String state, double stateRate) {
            this.state = state;
            this.stateRate = stateRate;
        }

        public BigDecimal getStatePrice(BigDecimal discountPrice) {
            return discountPrice.subtract(discountPrice.multiply(BigDecimal.valueOf(stateRate)));
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
        private double discoutRate;

        DiscoutRate(BigDecimal orderValue, double discoutRate) {
            this.orderValue = orderValue;
            this.discoutRate = discoutRate;
        }

        public BigDecimal getDiscountPrice(BigDecimal initPrice) {
            return initPrice.subtract(initPrice.multiply(BigDecimal.valueOf(discoutRate)));
        }
    }

}
