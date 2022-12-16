package com.gildedrose;

import java.util.*;
import java.util.stream.Collectors;

public class ItemsFactory {
    @FunctionalInterface
    interface ItemFactory {
        SuperItem create(Item item);
    }

    private final Map<String, ItemFactory> itemFactories = new HashMap<>();

    private void register(String itemName, ItemFactory f) {
        itemFactories.put(itemName, f);
    }

    public ItemsFactory() {
        register("Aged Brie", this::agedBrieFactory);
        register("Backstage passes to a TAFKAL80ETC concert", this::backstagePassFactory);
        register("Sulfuras, Hand of Ragnaros", this::sulfurasFactory);
    }

    private SuperItem standardFactory(Item item) {
        return new StandardItem(item);
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
        List<Item> test = Arrays.asList(items);

        return test.stream()
            .map(this::createItem)
            .collect(Collectors.toList());
    }

    private SuperItem createItem(Item item) {
        ItemFactory f = itemFactories.getOrDefault(item.name, this::standardFactory);
        return f.create(item);
    }

    private void run() {
        ItemsFactory register = new ItemsFactory();

        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Elixir of the Mongoose", 5, 7),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)
        };

        List<SuperItem> superItems = register.map(items);

        System.out.println(superItems);
    }

    public static void main(String[] args) {
        new ItemsFactory().run();
    }
}
