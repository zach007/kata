package com.hsbc.kata.gildedrose;

public class BackstageItem extends Item {
    public BackstageItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    static void updateBackstage(Item item, int currentDay) {
        if (currentDay >= 10) {
            item.increaseQuality(1);
        } else if (currentDay >= 5 && currentDay < 10) {
            item.increaseQuality(2);
        } else if (currentDay >= 0 && currentDay < 5) {
            item.increaseQuality(3);
        } else {
            item.quality = 0;
        }
    }
}
