package com.gildedrose;

import org.junit.jupiter.api.Test;
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
            "Aged Brie, 2, 1, 2, 3"
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
            "Backstage passes to a TAFKAL80ETC concert, 1, 4, 8, 1",
            "Backstage passes to a TAFKAL80ETC concert, 2, 6, 4, 2",
            "Backstage passes to a TAFKAL80ETC concert, 3, 5, 4, 0",
    })
    //TODO: ajustar este test y los siguientes
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
            "Almonds, 4, 4, 10"
    })
    void ShouldNotHaveQualityOverTheLimit(String name, int sellIn, int quality, int days){
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        var limit = 50;

        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        int updatedQuality = items[0].quality;
        int expectedQuality = limit;

        assertEquals(expectedQuality, updatedQuality);

    }

    @Test
    void ShouldKeepSellInAndQualityUnchanged(String name, int sellIn, int quality, int days, int expectedQuality){
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
            "Cheese, 7, 5, 3, 4",
            "Milk, 3, 5, 4, -1"
    })
    void ShouldDecreaseOneSellInPerDay(String name, int sellIn, int quality, int days, int expectedQuality){
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        int updatedSellIn = items[0].sellIn;

        assertEquals(expectedQuality, updatedSellIn);
    }
}
