package com.gildedrose;

import java.util.*;
import java.util.stream.Collectors;

class GildedRose {
    Item[] items;
    List<SuperItem> properItems = new ArrayList<SuperItem>();

    private ItemsFactory register = new ItemsFactory();

    public GildedRose(Item[] items) {
        this.items = items;

        properItems = register.map(items);
    }

    public void updateQuality() {
        for (SuperItem item : properItems) {
            item.updateQuality();
        }
    }
}
