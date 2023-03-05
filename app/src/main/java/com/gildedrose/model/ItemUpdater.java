package com.gildedrose.model;

public class ItemUpdater {
    public void updateAgedBrie(Item item) {
        if (item.quality < 50) {
            increaseQuality(item);
        }
        decreaseSellIn(item);
    }
    private void decreaseQuality(Item item) {
        item.quality--;
    }

    private void increaseQuality(Item item) {
        item.quality++;
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }
}