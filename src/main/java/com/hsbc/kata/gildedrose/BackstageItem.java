package com.hsbc.kata.gildedrose;

public class BackstageItem extends Item {
    public BackstageItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        int currentDay = sellIn - 1;
        if (currentDay >= 10) {
            increaseQuality(1);
        } else if (currentDay >= 5) {
            increaseQuality(2);
        } else if (currentDay >= 0) {
            increaseQuality(3);
        } else {
            quality = 0;
        }
        decreaseSellIn();
    }
}
