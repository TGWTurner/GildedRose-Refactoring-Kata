package com.gildedrose;

import java.util.ArrayList;
import java.util.Map;

class GildedRose {
    Item[] items;
    ArrayList<SuperItem> properItems = new ArrayList<SuperItem>();

    public GildedRose(Item[] items) {
        this.items = items;

        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie":
                    properItems.add(new AgedBrieItem(item));
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    properItems.add(new BackstagePassItem(item));
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    properItems.add(new SulfurasItem(item));
                    break;
                default:
                    properItems.add(new StandardItem(item));
                    break;
            }
        }
    }

    public void updateQuality() {
        for (SuperItem item : properItems) {
            item.updateQuality();
        }
    }
}
