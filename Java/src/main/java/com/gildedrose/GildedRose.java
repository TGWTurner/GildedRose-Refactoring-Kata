package com.gildedrose;

import java.util.*;

class GildedRose {
    private final List<SuperItem> properItems;

    public GildedRose(Item[] items) {
        ItemsFactory itemsFactory = new ItemsFactory();
        properItems = itemsFactory.map(items);
    }

    public void updateQuality() {
        for (SuperItem item : properItems) {
            item.updateQuality();
        }
    }

    public List<SuperItem> getItems() {
        return new ArrayList<SuperItem>(properItems);
    }
}
