package com.hsbc.kata.gildedrose;

public class AgedBrieItem extends Item {
    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public static void updateAgedBrie(Item item, int currentDay) {
        if (currentDay < 0) {
            item.increaseQuality(2);
        } else {
            item.increaseQuality(1);
        }
    }
}
