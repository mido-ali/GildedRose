package com.gildedrose;

public class AgedBrieItemStrategy implements ItemStrategy {

    @Override
    public Item updateItem(Item item) {
        int changeValue = item.sellIn < 0 ? 2 : 1;
        int newQuality = calculateItemQuality(item, changeValue);
        return new Item(item.name, item.sellIn - 1, newQuality);
    }

    private int calculateItemQuality(Item item, int changeValue) {
        int newQuality = item.quality + changeValue;
        boolean isValidValue = newQuality > 0 && newQuality < 50;
        if (isValidValue) {
            return newQuality;
        }
        return item.quality;
    }
}
