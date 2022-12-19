package com.gildedrose;

public class ConjuredItem extends SuperItem {

    public ConjuredItem(Item item) {
        super(item);
    }

    public void updateQuality() {
        decreaseItemQuality();
        decreaseItemQuality();

        decreaseSellInDays();

        if (sellIn < 0) {
            decreaseItemQuality();
            decreaseItemQuality();
        }
    }
}
