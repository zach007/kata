package com.hsbc.kata.parallelchange.field;

import com.google.common.collect.Lists;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ShoppingCart {
    private List<Integer> priceList = Lists.newArrayList();

    public void add(int price) {
        priceList.add(price);
    }

    public int calculateTotalPrice() {
        return priceList.stream().mapToInt(Integer::intValue).sum();
    }


    public boolean hasDiscount() {
        return calculateTotalPrice() >= 100;
    }

    public int numberOfProducts() {
        return priceList.size();
    }
}
