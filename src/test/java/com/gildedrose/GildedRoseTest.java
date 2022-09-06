package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void dexterityVestItemQualityDecreasesByNextDay() {
        Item[] items = new Item[]{new Item("+5 Dexterity Vest", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].toString(), new Item("+5 Dexterity Vest", 9, 19).toString());
    }

    @Test
    void elixirOfTheMongooseItemQualityDecreasesByNextDay() {
        Item[] items = new Item[]{new Item("Elixir of the Mongoose", 5, 7)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].toString(), new Item("Elixir of the Mongoose", 4, 6).toString());
    }

    @Test
    void agedBrieItemQualityIncreasesTheOlderItGets() {
        Item[] items = new Item[]{new Item("Aged Brie", 2, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].toString(), new Item("Aged Brie", 1, 1).toString());
    }

    @Test
    void qualityOfAnItemIsNeverMoreThan50() {
        Item[] items = new Item[]{new Item("+5 Dexterity Vest", 10, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].toString(), new Item("+5 Dexterity Vest", 9, 50).toString());
    }

    @Test
    void qualityOfAgedBrieItemIsNeverMoreThan50() {
        Item[] items = new Item[]{new Item("Aged Brie", 2, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].toString(), new Item("Aged Brie", 1, 50).toString());
    }

    @Test
    void sulfurasLegendaryItemNeverSoldOrDecreasesInQuality() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].toString(), new Item("Sulfuras, Hand of Ragnaros", 0, 80).toString());
    }

    @Test
    void backstagePassesItemQualityIncreasesTheOlderItGets() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].toString(), new Item("Backstage passes to a TAFKAL80ETC concert", 14, 21).toString());
    }

    @Test
    void backstagePassesItemQualityIncreasesByTwoWhenThereAreTenDays() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].toString(), new Item("Backstage passes to a TAFKAL80ETC concert", 9, 22).toString());
    }

    @Test
    void backstagePassesItemQualityIncreasesByTwoWhenThereAreLessThanTenDaysAndMoreThanFiveDays() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].toString(), new Item("Backstage passes to a TAFKAL80ETC concert", 5, 22).toString());
    }

    @Test
    void backstagePassesItemQualityIncreasesByThreeWhenThereAreFiveDays() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].toString(), new Item("Backstage passes to a TAFKAL80ETC concert", 4, 23).toString());
    }

    @Test
    void backstagePassesItemQualityIncreasesByThreeWhenThereAreLessThanFiveDaysAndMoreThanZeroDays() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].toString(), new Item("Backstage passes to a TAFKAL80ETC concert", 0, 23).toString());
    }

    @Test
    void backstagePassesItemQualityDropsToZeroAfterConcert() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].toString(), new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0).toString());
    }
}
