package com.gildedrose.model;

public class ConjuredUpdater extends ItemUpdater {
    @Override
    public void updateItem(Item item) {
        decreaseQuality(item);
        decreaseQuality(item);
        decreaseSellIn(item);
    }
}
