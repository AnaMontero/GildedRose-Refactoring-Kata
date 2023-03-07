package com.gildedrose.model;

public class BackstagePassesUpdater extends ItemUpdater {
    public void updateItem(Item item) {
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
}
