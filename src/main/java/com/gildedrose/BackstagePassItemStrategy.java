package com.gildedrose;

public class BackstagePassItemStrategy implements ItemStrategy {

    @Override
    public Item updateItem(Item item) {
        int newQuality;
        newQuality = calculateQuality(item.quality, 1);
        if (item.sellIn < 11) {
            newQuality = calculateQuality(newQuality, 1);
        }
        if (item.sellIn < 6) {
            newQuality = calculateQuality(newQuality, 1);
        }
        if (item.sellIn < 1) {
            newQuality = 0;
        }
        return new Item(item.name, item.sellIn - 1, newQuality);
    }

    private int calculateQuality(int oldQuality, int changeValue) {
        int newQuality = oldQuality + changeValue;
        boolean isValidValue = newQuality > 0 && newQuality < 50;
        if (isValidValue) {
            return newQuality;
        }
        return oldQuality;
    }
}
