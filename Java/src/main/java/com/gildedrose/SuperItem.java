package com.gildedrose;

public class SuperItem extends Item {

    public SuperItem(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    protected void increaseItemQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }

    protected void decreaseItemQuality() {
        if (quality > 0) {
            quality = quality - 1;
        }
    }

    protected void decreaseSellInDays() {
        sellIn = sellIn - 1;
    }

    protected void updateQuality() {
        return;
    }
}
