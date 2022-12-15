package com.gildedrose;

import java.util.Map;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;

        //map from silly old items to new fancy OO items
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie":
                    //= new AgedBrieItem(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    //= new BackstagePassItem(item);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    //= new SulfurasItem(item);
                    break;
                default:
                    //=new StandardItem(item);
                    break;
            }
        }

        //create map from item => superItem subclasses based on name
        Item test = new Item("name", 5, 5);
        SuperItem superTest = new SuperItem(test);
        SuperItem standardTest = new StandardItem(test);
        SuperItem brieTest = new AgedBrieItem(test);
        SuperItem sulfurasTest = new SulfurasItem(test);
        SuperItem backstageTest = new BackstagePassItem(test);
    }

    public void updateQuality() {
        SuperItem[] items = new SuperItem[] {
            new StandardItem("item", 5, 0),
            new BackstagePassItem("item", 5, 0),
            new AgedBrieItem("item", 5, 0)
        };

        for (SuperItem item : items) {
            item.updateQuality();
        }
    }
}
