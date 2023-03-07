package com.gildedrose.model;

public class RegularItemUpdater extends ItemUpdater {

    public void updateItem(Item item){
        decreaseQuality(item);
        decreaseSellIn(item);

        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }
    protected void decreaseQuality(Item item) {
        if (item.quality > 0) item.quality--;
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }
}
