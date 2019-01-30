package com.hsbc.kata.gildedrose;

public class NormalItem extends Item {
    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public static void updateNormalItem(Item item, int currentDay) {
        if (currentDay < 0) {
            item.decreaseQuality(2);
        } else {
            item.decreaseQuality(1);
        }
    }
}
