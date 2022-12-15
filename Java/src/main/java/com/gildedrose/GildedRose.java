package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void increaseItemQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseItemQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void decreaseSellInDays(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void updateAgedBrieQuality(Item item) {
        increaseItemQuality(item);

        decreaseSellInDays(item);

        if (item.sellIn < 0) {
            increaseItemQuality(item);
        }
    }
    private void updateBackstagePassQuality(Item item) {
        if (item.quality < 50) {
            increaseItemQuality(item);

            if (item.sellIn < 11) {
                increaseItemQuality(item);
            }

            if (item.sellIn < 6) {
                increaseItemQuality(item);
            }
        }

        decreaseSellInDays(item);

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void updateStandardItemQuality(Item item) {
        decreaseItemQuality(item);

        decreaseSellInDays(item);

        if (item.sellIn < 0) {
            decreaseItemQuality(item);
        }
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie":
                    updateAgedBrieQuality(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    updateBackstagePassQuality(item);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    //I'm an empty bucket \_/
                    break;
                default:
                    updateStandardItemQuality(item);
            }
        }
    }
}
