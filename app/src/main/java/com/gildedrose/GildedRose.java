package com.gildedrose;

import com.gildedrose.model.*;

class GildedRose {
    private final Item[] items;

    private final RegularItemUpdater regularItemUpdater;
    private final AgedBrieUpdater agedBrieUpdater;
    private final BackstagePassesUpdater backstagePassesUpdater;
    private final ConjuredUpdater conjuredUpdater;

    public GildedRose(Item[] items) {
        this.items = items;
        this.regularItemUpdater = new RegularItemUpdater();
        this.agedBrieUpdater = new AgedBrieUpdater();
        this.backstagePassesUpdater = new BackstagePassesUpdater();
        this.conjuredUpdater = new ConjuredUpdater();
    }

    public void updateQuality() {
        for (Item item : items) {
            if (isAgedBrie(item)) {
                agedBrieUpdater.updateItem(item);
            }
            else if (isBackstagePasses(item)) {
                backstagePassesUpdater.updateItem(item);
            }
            else if (isConjured(item)) {
                conjuredUpdater.updateItem(item);
            }
            else if(!isSulfuras(item)){
                regularItemUpdater.updateItem(item);
            }

        }
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isBackstagePasses(Item item) {
        return item.name.toLowerCase().startsWith("backstage passes");
    }

    private boolean isSulfuras(Item item) {
        return item.name.toLowerCase().startsWith("sulfuras");
    }

    private boolean isConjured(Item item){
        return  item.name.toLowerCase().startsWith("conjured");
    }
}