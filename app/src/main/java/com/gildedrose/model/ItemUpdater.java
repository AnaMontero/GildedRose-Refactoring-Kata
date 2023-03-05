package com.gildedrose.model;

public class ItemUpdater {
    public void updateRegularItem(Item item) {
        decreaseQuality(item);
        decreaseSellIn(item);

        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }

    public void updateAgedBrieItem(Item item) {
        increaseQuality(item);
        decreaseSellIn(item);
    }

    public void updateBackstagePassesItem(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;
        }
        else {
            increaseQuality(item);

            if (item.sellIn < 11) {
                increaseQuality(item);
            }

            if (item.sellIn < 6) {
                increaseQuality(item);
            }
        }
        decreaseSellIn(item);
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) item.quality--;
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) item.quality++;
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }
}