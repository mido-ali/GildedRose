package com.gildedrose;

public class NormalItemStrategy implements ItemStrategy {

    @Override
    public Item updateItem(Item item) {
        int decreaseRate = item.sellIn < 1 ? 2 : 1;
        int newQuality = calculateItemQuality(item, -decreaseRate);
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
