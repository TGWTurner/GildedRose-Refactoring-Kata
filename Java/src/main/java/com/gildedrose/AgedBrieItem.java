package com.gildedrose;

public class AgedBrieItem extends SuperItem {

    public AgedBrieItem(Item item) {
        super(item);
    }

    public void updateQuality() {
        increaseItemQuality();

        decreaseSellInDays();

        if (sellIn < 0) {
            increaseItemQuality();
        }
    }
}
