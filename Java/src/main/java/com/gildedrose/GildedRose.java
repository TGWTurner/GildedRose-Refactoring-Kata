package com.gildedrose;

import sun.jvm.hotspot.types.CIntegerField;

import java.util.*;
import java.util.stream.Collectors;

class GildedRose {
    /**
     * Change this to use a factory that responds with a strategy
     *  then for the item itl apply a strategy for the updateQuality method
     */
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            StrategyContext context = new StrategyContext(item.name);
            Map<String, Integer> result = context.updateQuality(item);

            item.quality = result.get("quality");
            item.sellIn = result.get("sellIn");
        }
    }

    public List<Item> getItems() {
        return new ArrayList<Item>(Arrays.asList(items));
    }
}
