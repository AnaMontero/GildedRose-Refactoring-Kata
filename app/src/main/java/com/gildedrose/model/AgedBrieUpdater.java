package com.gildedrose.model;

public class AgedBrieUpdater extends ItemUpdater {
    public void updateItem(Item item) {
        increaseQuality(item);
        decreaseSellIn(item);
    }
}