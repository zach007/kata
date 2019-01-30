package com.hsbc.kata.gildedrose;

public class AgedBrieItem extends Item {
    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update(int currentDay) {
        if (currentDay < 0) {
            increaseQuality(2);
        } else {
            increaseQuality(1);
        }
        decreaseSellInByOne();
    }
}
