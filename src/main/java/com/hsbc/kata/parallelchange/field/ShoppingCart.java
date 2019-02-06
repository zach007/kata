package com.hsbc.kata.parallelchange.field;

import com.google.common.collect.Lists;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ShoppingCart {
    private int price;
    private List<Integer> priceList = Lists.newArrayList();

    public void addPrice(int price) {
        priceList.add(price);
    }

    @Deprecated
    public void add(int price) {
        log.warn("@Deprecated");
        addPrice(price);
    }

    public int getTotalPrice() {
        return priceList.stream().mapToInt(Integer::intValue).sum();
    }

    @Deprecated
    public int calculateTotalPrice() {
        return getTotalPrice();
    }


    public boolean isDiscount() {
        return getTotalPrice() >= 100;
    }

    @Deprecated
    public boolean hasDiscount() {
        return isDiscount();
    }

    public int getProductNumber() {
        return priceList.size();
    }

    @Deprecated
    public int numberOfProducts() {
        return getProductNumber();
    }
}
