package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @ParameterizedTest
    @CsvSource({
            "Cheese, 5, 3, 1, 2",
    })
    void updateQualityCorrectly(String name, int sellIn, int quality, int days, int expectedQuality) {
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
            "Cheese, 5, 3, 1, 4",
    })
    void updateSellInCorrectly(String name, int sellIn, int quality, int days, int expectedQuality) {
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }
        int updatedSellIn = items[0].sellIn;
        assertEquals(expectedQuality, updatedSellIn);
    }
}
