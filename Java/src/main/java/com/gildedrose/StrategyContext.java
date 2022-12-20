package com.gildedrose;

import java.util.Map;

public class StrategyContext {
    private ItemStrategy strategy = null;

    public StrategyContext(String name) {
        //TODO: add other strategies
        switch (name) {
            case "Aged Brie":
                strategy = new AgedBrieStrategy();
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                strategy = new BackstagePassStrategy();
                break;
            case "Sulfuras, Hand of Ragnaros":
                strategy = new SulfurasStrategy();
                break;
            case "Conjured":
                strategy = new ConjuredStrategy();
                break;
            default:
                strategy = new GenericStrategy();
                break;
        }
    }

    public Map<String, Integer> updateQuality(Item item) {
        return strategy.updateQuality(item);
    }
}
