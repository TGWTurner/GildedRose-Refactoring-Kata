package com.gildedrose;

public class AgedBrieItem extends SuperItem {
    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public AgedBrieItem(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    public void updateQuality() {
        increaseItemQuality();

        decreaseSellInDays();

        if (sellIn < 0) {
            increaseItemQuality();
        }
    }
}
