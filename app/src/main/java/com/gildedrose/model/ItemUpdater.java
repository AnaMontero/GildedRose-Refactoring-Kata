package com.gildedrose.model;

public abstract class ItemUpdater {
    public abstract void updateItem(Item item);

    protected void decreaseQuality(Item item) {
        if (item.quality > 0) item.quality--;
    }

    protected void increaseQuality(Item item) {
        if (item.quality < 50) item.quality++;
    }

    protected void decreaseSellIn(Item item) {
        item.sellIn--;
    }
}