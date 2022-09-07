package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

class GildedRose {
    static final String AGED_BRIE = "Aged Brie";
    static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    static final String Conjured = "Conjured";
    Item[] items;
    static Map<String, ItemStrategy> itemStrategyMap = new HashMap<>();

    static {
        itemStrategyMap.put(AGED_BRIE, new AgedBrieItemStrategy());
        itemStrategyMap.put(BACKSTAGE_PASSES, new BackstagePassItemStrategy());
        itemStrategyMap.put(SULFURAS, new SulfurasItemStrategy());
        itemStrategyMap.put(Conjured, new ConjuredItemStrategy());
    }

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            ItemStrategy itemStrategy = itemStrategyMap.getOrDefault(items[i].name, new NormalItemStrategy());
            items[i] = itemStrategy.updateItem(items[i]);
        }
    }
}