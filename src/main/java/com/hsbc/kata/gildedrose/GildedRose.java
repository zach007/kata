package com.hsbc.kata.gildedrose;

public class GildedRose {
    public static final String INCREASE = "increase";
    public static final String DECREASE = "decrease";
    public static final String CLEAN = "Clean";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
/*            if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }*/
            degradeQualityTwice(items[i]);
        }
    }

    private void degradeQualityTwice(Item item) {
        String name = item.name;
        int currentDay = item.sellIn - 1;
        if (name.equals("Sulfuras, Hand of Ragnaros")) {

        } else {
            if (name.equals("Aged Brie")) {
                updateAgedBrie(item, currentDay);
            } else if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                updateBackstage(item, currentDay);
            } else if (name.equals("Conjured")) {
                decreaseQuality(item, 2);
            } else {
                updateNormalItem(item, currentDay);
            }
            decreaseSellInByOne(item);
        }
    }

    private void updateNormalItem(Item item, int currentDay) {
        if (currentDay < 0) {
            decreaseQuality(item, 2);
        } else {
            decreaseQuality(item, 1);
        }
    }

    private void updateBackstage(Item item, int currentDay) {
        if (currentDay >= 10) {
            increaseQuality(item, 1);
        } else if (currentDay >= 5 && currentDay < 10) {
            increaseQuality(item, 2);
        } else if (currentDay >= 0 && currentDay < 5) {
            increaseQuality(item, 3);
        } else {
            item.quality = 0;
        }
    }

    private void updateAgedBrie(Item item, int currentDay) {
        if (currentDay < 0) {
            increaseQuality(item, 2);
        } else {
            increaseQuality(item, 1);
        }
    }

    private void decreaseSellInByOne(Item item) {
        item.sellIn -= 1;
    }

    private void increaseQuality(Item item, int step) {
        if (item.quality < 50) {
            item.quality += step;
        }
    }

    private void decreaseQuality(Item item, int step) {
        if (item.quality > 0) {
            item.quality -= step;
        }
    }
}

