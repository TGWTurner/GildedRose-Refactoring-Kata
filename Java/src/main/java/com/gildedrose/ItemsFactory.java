package com.gildedrose;

import java.util.*;
import java.util.stream.Collectors;

public class ItemsFactory {
    @FunctionalInterface
    interface ItemFactory {
        SuperItem create(Item item);
    }

    private final Map<String, ItemFactory> itemFactories = new HashMap<>();

    private void register(String itemName, ItemFactory itemFactory) {
        itemFactories.put(itemName, itemFactory);
    }

    public ItemsFactory() {
        register("Aged Brie", this::agedBrieFactory);
        register("Backstage passes to a TAFKAL80ETC concert", this::backstagePassFactory);
        register("Sulfuras, Hand of Ragnaros", this::sulfurasFactory);
        register("Conjured", this::conjuredFactory);
    }

    private SuperItem standardFactory(Item item) {
        return new StandardItem(item);
    }

    private SuperItem conjuredFactory(Item item) {
        return new ConjuredItem(item);
    }


    private SuperItem agedBrieFactory(Item item) {
        return new AgedBrieItem(item);
    }

    private SuperItem backstagePassFactory(Item item) {
        return new BackstagePassItem(item);
    }

    private SuperItem sulfurasFactory(Item item) {
        return new SulfurasItem(item);
    }

    public List<SuperItem> map(Item[] items) {
        List<Item> listItems = Arrays.asList(items);

        return listItems.stream()
            .map(this::createItem)
            .collect(Collectors.toList());
    }

    private SuperItem createItem(Item item) {
        ItemFactory itemFactory = itemFactories.getOrDefault(item.name, this::standardFactory);
        return itemFactory.create(item);
    }
}
