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
            //increasesQualityByOlder(items[i]);
        }
    }

    private void degradeQualityTwice(Item item) {
        String name = item.name;
        int currentDay = item.sellIn - 1;
        if (name.equals("Sulfuras, Hand of Ragnaros")) {

        } else {
            if (name.equals("Aged Brie")) {
                if (currentDay < 0) {
                    updateQualityByTimes(item, INCREASE, 2);
                } else {
                    updateQualityByTimes(item, INCREASE, 1);
                }
            } else if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (currentDay >= 10) {
                    updateQualityByTimes(item, INCREASE, 1);
                } else if (currentDay >= 5 && currentDay < 10) {
                    updateQualityByTimes(item, INCREASE, 2);
                } else if (currentDay >= 0 && currentDay < 5) {
                    updateQualityByTimes(item, INCREASE, 3);
                } else {
                    updateQualityByTimes(item, CLEAN, 0);
                }
            } else if (name.equals("Conjured")) {
                updateQualityByTimes(item, DECREASE, 2);
            } else {
                if (currentDay < 0) {
                    updateQualityByTimes(item, DECREASE, 2);
                } else {
                    updateQualityByTimes(item, DECREASE, 1);
                }
            }
            decreaseSellInByOne(item);
            updateQuality(item);
        }
    }

    private void decreaseSellInByOne(Item item) {
        item.sellIn -= 1;
    }

    private void updateQualityByTimes(Item item, String command, int step) {
        if (command.equals(INCREASE)) {
            item.quality += step;
        } else if (command.equals(DECREASE)) {
            item.quality -= step;
        } else if (command.equals(CLEAN)) {
            item.quality = 0;
        } else {

        }
    }

    private void updateQuality(Item item) {
        int currentQuality = item.quality;
        int quality = currentQuality < 0 ? 0 : currentQuality;
        item.quality = quality > 50 ? 50 : quality;
    }

}

