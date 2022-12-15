package com.gildedrose;

public class StandardItem extends SuperItem {

    public StandardItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }
    public StandardItem(Item item) {
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
