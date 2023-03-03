package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @ParameterizedTest
    @CsvSource({
            "Cheese, 7, 5, 3, 2",
            "Potatoes, 14, 6, 4, 2"
    })
    void ShouldDecreaseOneQualityPerDay(String name, int sellIn, int quality, int days, int expectedQuality) {
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        int updatedQuality = items[0].quality;

        assertEquals(expectedQuality, updatedQuality);
    }

    @ParameterizedTest
    @CsvSource({
            "Fish, 1, 4, 2, 1",
            "Chicken, 2, 6, 3, 2",
            "Milk, 3, 5, 4, 0",
    })
    void ShouldDecreaseQualityTwiceFasterWhenSellInIsPassed(String name, int sellIn, int quality, int days, int expectedQuality){
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        int updatedQuality = items[0].quality;

        assertEquals(expectedQuality, updatedQuality);
    }

    @ParameterizedTest
    @CsvSource({
            "Eggs, 4, 4, 10, 0"
    })
    void ShouldNotHaveNegativeQuality(String name, int sellIn, int quality, int days, int expectedQuality){
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        int updatedQuality = items[0].quality;

        assertEquals(expectedQuality, updatedQuality);
    }

    @ParameterizedTest
    @CsvSource({
            "Aged Brie, 2, 1, 2, 3",
            "Aged Brie, 8, 4, 5, 9"
    })
    void ShouldIncreaseQualityForAgedBrieItem(String name, int sellIn, int quality, int days, int expectedQuality){
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        int updatedQuality = items[0].quality;

        assertEquals(expectedQuality, updatedQuality);
    }

    @ParameterizedTest
    @CsvSource({
            "Backstage passes to a TAFKAL80ETC concert, 8, 4, 5, 14",
            "Backstage passes to a TAFKAL80ETC concert, 4, 6, 7, 9",
            "Backstage passes to a TAFKAL80ETC concert, 4, 12, 4, 0",
    })
    //TODO: pendiente corregir test
    void ShouldIncreaseQualityDependingOnRemainingSellIn(String name, int sellIn, int quality, int days, int expectedQuality){
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        int updatedQuality = items[0].quality;

        assertEquals(expectedQuality, updatedQuality);
    }

    @ParameterizedTest
    @CsvSource({
            "Aged Brie, 8, 49, 5",
            "Backstage passes to a TAFKAL80ETC concert, 40, 12, 40"
    })
    void ShouldNotHaveQualityOverTheLimit(String name, int sellIn, int quality, int days){
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        int limit = 50;

        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        int updatedQuality = items[0].quality;

        assertEquals(limit, updatedQuality);

    }

    @ParameterizedTest
    @CsvSource({
            "'Sulfuras, Hand of Ragnaros', 3, 9, 5, 3, 9",
    })
    void ShouldKeepSellInAndQualityUnchanged(String name, int sellIn, int quality, int days, int expectedSellIn, int expectedQuality){
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        int updatedQuality = items[0].quality;
        int updatedSellIn = items[0].sellIn;

        assertEquals(expectedSellIn, updatedSellIn);
        assertEquals(expectedQuality, updatedQuality);
    }

    @ParameterizedTest
    @CsvSource({
            "Cheese, 7, 5, 3, 4",
            "Milk, 3, 5, 4, -1"
    })
    void ShouldDecreaseOneSellInPerDay(String name, int sellIn, int quality, int days, int expectedSellIn){
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        int updatedSellIn = items[0].sellIn;

        assertEquals(expectedSellIn, updatedSellIn);
    }
}
