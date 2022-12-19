package com.gildedrose;

import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.debugger.MachineDescriptionPPC64;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemsFactoryTest {
    @Test
    public void testFactoryCreatsStandardItem() {
        ItemsFactory itemsFactory = new ItemsFactory();
        Item[] items = new Item[] {
            new Item("item", 5, 5),
        };

        List<SuperItem> superItemList = itemsFactory.map(items);

        assertEquals(StandardItem.class, superItemList.get(0).getClass());
    }

    @Test
    public void testFactoryCreatsAgedBrieItem() {
        ItemsFactory itemsFactory = new ItemsFactory();
        Item[] items = new Item[] {
            new Item("Aged Brie", 5, 5),
        };

        List<SuperItem> superItemList = itemsFactory.map(items);

        assertEquals(AgedBrieItem.class, superItemList.get(0).getClass());
    }

    @Test
    public void testFactoryCreatsBackstagePassItem() {
        ItemsFactory itemsFactory = new ItemsFactory();
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 5),
        };

        List<SuperItem> superItemList = itemsFactory.map(items);

        assertEquals(BackstagePassItem.class, superItemList.get(0).getClass());
    }

    @Test
    public void testFactoryCreatsSulfurasItem() {
        ItemsFactory itemsFactory = new ItemsFactory();
        Item[] items = new Item[] {
            new Item("Sulfuras, Hand of Ragnaros", 5, 5),
        };

        List<SuperItem> superItemList = itemsFactory.map(items);

        assertEquals(SulfurasItem.class, superItemList.get(0).getClass());
    }



    @Test
    public void testFactoryCreatsConjuredItem() {
        ItemsFactory itemsFactory = new ItemsFactory();
        Item[] items = new Item[] {
            new Item("Conjured", 5, 5),
        };

        List<SuperItem> superItemList = itemsFactory.map(items);

        assertEquals(ConjuredItem.class, superItemList.get(0).getClass());
    }
}
