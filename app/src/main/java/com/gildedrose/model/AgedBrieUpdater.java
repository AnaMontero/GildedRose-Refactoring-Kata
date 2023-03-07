package com.gildedrose.model;

public class AgedBrieUpdater extends ItemUpdater {
    @Override
    public void updateItem(Item item) {
        increaseQuality(item);
        decreaseSellIn(item);
    }
}