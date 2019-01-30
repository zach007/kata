package com.hsbc.kata.gildedrose;

public class Item {
    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void update() {

    }

    public void increaseQuality(int step) {
        int quality = this.quality + step;
        int maxQuality = quality > 50 ? 50 : quality;
        this.quality = maxQuality;
    }

    public void decreaseQuality(int step) {
        int quality = this.quality - step;
        int minQuality = quality < 0 ? 0 : quality;
        this.quality = minQuality;
    }

    public void decreaseSellIn() {
        sellIn -= 1;
    }
}
