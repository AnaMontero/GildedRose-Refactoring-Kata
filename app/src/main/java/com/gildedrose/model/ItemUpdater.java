package com.gildedrose.model;

public class ItemUpdater {
    public void updateAgedBrie(Item item) {
        increaseQuality(item);
        decreaseSellIn(item);
    }

    public void updateBackstagePasses(Item item) {
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
        item.quality--;
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }
}