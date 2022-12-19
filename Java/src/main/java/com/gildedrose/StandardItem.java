package com.gildedrose;

public class StandardItem extends SuperItem {
    public StandardItem(Item item) {
        super(item);
    }

    public void updateQuality() {
        decreaseItemQuality();

        decreaseSellInDays();

        if (sellIn < 0) {
            decreaseItemQuality();
        }
    }
}
