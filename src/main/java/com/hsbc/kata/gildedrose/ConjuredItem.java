package com.hsbc.kata.gildedrose;

public class ConjuredItem extends Item {
    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update(int currentDay) {
        decreaseQuality(2);
        decreaseSellInByOne();
    }

}
