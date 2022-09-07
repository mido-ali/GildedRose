package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
            handleSellIn(item);
        }
    }

    private void updateItemQuality(Item item) {
        boolean shouldDecrease = !item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE_PASSES) && !item.name.equals(SULFURAS);
        if (shouldDecrease) {
            int decreaseRate = item.sellIn < 1 ? 2 : 1;
            calculateItemQuality(item, -decreaseRate);
        }
        if (item.name.equals(AGED_BRIE)) {
            calculateAgedBrieQuality(item);
        }
        if (item.name.equals(BACKSTAGE_PASSES)) {
            calculateBackstagePassesQuality(item);
        }
    }

    private void handleSellIn(Item item) {
        if (!item.name.equals(SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void calculateBackstagePassesQuality(Item item) {
        calculateItemQuality(item, 1);
        if (item.sellIn < 11) {
            calculateItemQuality(item, 1);
        }
        if (item.sellIn < 6) {
            calculateItemQuality(item, 1);
        }
        if (item.sellIn < 1) {
            item.quality = item.quality - item.quality;
        }
    }

    private void calculateAgedBrieQuality(Item item) {
        int changeValue = item.sellIn < 0 ? 2 : 1;
        calculateItemQuality(item, changeValue);
    }

    private void calculateItemQuality(Item item, int changeValue) {
        int newQuality = item.quality + changeValue;
        boolean isValidValue = newQuality > 0 && newQuality < 50;
        if (isValidValue) {
            item.quality = newQuality;
        }
    }
}