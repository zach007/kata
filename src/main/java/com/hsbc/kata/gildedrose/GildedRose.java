package com.hsbc.kata.gildedrose;

public class GildedRose {
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
        int currentQuality;
        if (name.equals("Aged Brie")) {
            if (currentDay < 0) {
                currentQuality = item.quality + 2;
            } else {
                currentQuality = item.quality + 1;
            }
            decreaseSellInByOne(item);
            updateQuality(item, currentQuality);
        } else if (name.equals("Sulfuras, Hand of Ragnaros")) {
            // do nothing
        } else if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (currentDay >= 10) {
                currentQuality = item.quality + 1;
            } else if (currentDay >= 5 && currentDay < 10) {
                currentQuality = item.quality + 2;
            } else if (currentDay >= 0 && currentDay < 5) {
                currentQuality = item.quality + 3;
            } else {
                currentQuality = 0;
            }
            decreaseSellInByOne(item);
            updateQuality(item, currentQuality);
        } else if (name.equals("Conjured")) {
            currentQuality = item.quality - 2;
            decreaseSellInByOne(item);
            updateQuality(item, currentQuality);
        } else {
            if (currentDay < 0) {
                currentQuality = item.quality - 2;
            } else {
                currentQuality = item.quality - 1;
            }
            decreaseSellInByOne(item);
            updateQuality(item, currentQuality);
        }
    }

    private void decreaseSellInByOne(Item item) {
        item.sellIn -= 1;
    }

    private void updateQuality(Item item, int currentQuality) {
        int quality = currentQuality < 0 ? 0 : currentQuality;
        item.quality = quality > 50 ? 50 : quality;
    }


    private void increasesQualityByOlder(Item item) {
        String name = item.name;
        int quality = item.quality;
        int sellIn = item.sellIn;
        if (name.equals("Aged Brie")) {
            if (sellIn < 0) {
                quality += 1;
            } else {
                quality -= 1;
            }
        }
        item.quality = quality < 0 ? 0 : quality;
        item.sellIn = sellIn - 1;
    }
}

