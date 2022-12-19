package com.gildedrose;

public class BackstagePassItem extends SuperItem {
    public BackstagePassItem(Item item) {
        super(item);
    }

    public void updateQuality() {
        if (quality < 50) {
            increaseItemQuality();

            if (sellIn < 11) {
                increaseItemQuality();
            }

            if (sellIn < 6) {
                increaseItemQuality();
            }
        }

        decreaseSellInDays();

        if (sellIn < 0) {
            quality = 0;
        }
    }
}
