package com.gildedrose;

public class SulfurasItem extends SuperItem {
    public SulfurasItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public SulfurasItem(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    public void updateQuality() {
        //nothing here but us chickens...
    }
}
