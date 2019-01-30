package com.hsbc.kata.gildedrose;

public class NormalItem extends Item {
    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        int currentDay = sellIn - 1;
        if (currentDay < 0) {
            decreaseQuality(2);
        } else {
            decreaseQuality(1);
        }
        decreaseSellIn();
    }
}
