package com.gildedrose;

public class BackstagePassItem extends SuperItem {
    public BackstagePassItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public BackstagePassItem(Item item) {
        super(item.name, item.sellIn, item.quality);
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
