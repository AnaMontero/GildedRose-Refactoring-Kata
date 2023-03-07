package com.gildedrose;

import com.gildedrose.model.AgedBrieUpdater;
import com.gildedrose.model.BackstagePassesUpdater;
import com.gildedrose.model.Item;
import com.gildedrose.model.ItemUpdater2;

class GildedRose {
    private final Item[] items;

    private final ItemUpdater2 itemUpdater2;
    private final AgedBrieUpdater agedBrieUpdater;
    private final BackstagePassesUpdater backstagePassesUpdater;

    public GildedRose(Item[] items) {
        this.items = items;
        this.agedBrieUpdater = new AgedBrieUpdater();
        this.itemUpdater2 = new ItemUpdater2();
        this.backstagePassesUpdater = new BackstagePassesUpdater();
    }

    public void updateQuality() {
        for (Item item : items) {
            if (isAgedBrie(item)) {
                agedBrieUpdater.updateItem(item);
            }
            else if (isBackstagePasses(item)) {
                backstagePassesUpdater.updateItem(item);
            }
            else if(!isSulfuras(item)){
                itemUpdater2.updateRegularItem(item);
            }
        }
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isBackstagePasses(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }
}