package com.gildedrose.model;

public class AgedBrieUpdater extends ItemUpdater {
    public void updateItem(Item item) {
        increaseQuality(item);
        decreaseSellIn(item);
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) item.quality++;
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }
}
